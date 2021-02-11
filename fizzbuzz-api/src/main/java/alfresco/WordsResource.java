package alfresco;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Produces("application/json")
public class WordsResource {

    private final AppContext appContext;
    private final FizzBuzzGeneratorUseCase generator;

    public WordsResource(AppContext appContext) {
        this.appContext = appContext;
        generator = appContext.getFizzBuzzGenerator();
    }

    @GET
    @Path("words")
    public Words words() {
        generator.generateWords(20);
        return new Words();
    }
}