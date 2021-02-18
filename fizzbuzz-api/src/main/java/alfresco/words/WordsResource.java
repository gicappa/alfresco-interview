package alfresco.words;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import alfresco.AppContext;
import alfresco.ErrorReponse;
import alfresco.FizzBuzzUnhandledEx;
import alfresco.LimitMinorThanOneEx;
import alfresco.WordGeneratorService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import static java.lang.Integer.parseInt;

@Path("/")
@Produces("application/json")
public class WordsResource {

    private final WordGeneratorService generator;

    @SuppressWarnings("CdiInjectionPointsInspection")
    public WordsResource(AppContext appContext) {
        generator = appContext.getFizzBuzzGenerator();
    }

    @GET
    @Path("words")
    @Operation(
        summary = "Get a list of fizzbuzz words",
        description = "FizzBuzz maps a number positive number into a string according to" +
            "a set of rule. The number can be translated in the same number in string format" +
            "or in a string 'fizz' or 'buzz' or 'fizzbuzz' or 'alfresco'")
    @Parameters(value = @Parameter(name = "limit",
        description = "it is the upper bound of the fizzbuzz words generation"))
    @APIResponses(value = {
        @APIResponse(
            responseCode = "200",
            description = "It returns the list of fizzbuzz words generated translating" +
                "number from 1 to the 'limit' parameter",
            content = @Content(schema = @Schema(implementation = WordsResponse.class))),
        @APIResponse(
            responseCode = "400",
            description = "The 'limit' params is not in a number format",
            content = @Content(schema = @Schema(implementation = ErrorReponse.class))),
        @APIResponse(
            responseCode = "500",
            description = "Internal Error generate by an unhandled exception",
            content = @Content(schema = @Schema(implementation = ErrorReponse.class)))})

    public Response words(@DefaultValue("20") @QueryParam("limit") String limit) {
        try {

            int safeLimit = parseInt(limit);
            var words = new WordsResponse(generator.generateWords(safeLimit), safeLimit);
            return Response.status(200).entity(words).build();

        } catch (NumberFormatException nfe) {

            var errors = new ErrorReponse(
                "ValidationError",
                "FB001",
                "The limit value must be a number.");

            return Response.status(400).entity(errors).build();

        } catch (LimitMinorThanOneEx lmtoe) {

            var errors = new ErrorReponse(
                "ValidationError",
                "FB002",
                "The limit value must be a number equal or greater than one.");

            return Response.status(400).entity(errors).build();
        } catch (FizzBuzzUnhandledEx fbuhe) {

            var errors = new ErrorReponse(
                "InternalError",
                "FB003",
                "Internal unrecoverable error.");

            return Response.status(500).entity(errors).build();
        }
    }
}