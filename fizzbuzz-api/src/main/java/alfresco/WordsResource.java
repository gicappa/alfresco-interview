package alfresco;

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

            var words = generator.generateWords(parseInt(limit));

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