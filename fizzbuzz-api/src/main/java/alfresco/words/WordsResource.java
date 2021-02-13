package alfresco.words;

import alfresco.AppContext;
import alfresco.ErrorReponse;
import alfresco.WordGeneratorService;

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