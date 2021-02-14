package alfresco.words;

import alfresco.AppContext;
import alfresco.ErrorReponse;
import alfresco.WordGeneratorService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

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
    public Response words(
        @DefaultValue("20")
        @QueryParam("limit")
            String limit) {
        try {

            int safeLimit = parseInt(limit);
            var words = new WordsResponse(generator.generateWords(safeLimit), safeLimit);

            return Response.status(200).entity(words).build();

        } catch (NumberFormatException nfe) {

            var errors = new ErrorReponse(
                "ValidationError",
                "FB001",
                "The query parameter limit must be a number.");

            return Response.status(400).entity(errors).build();
        }
    }
}