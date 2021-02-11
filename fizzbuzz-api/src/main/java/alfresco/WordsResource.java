package alfresco;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/")
@Produces("application/json")
public class WordsResource {

    private final FizzBuzzGeneratorUseCase generator;

    public WordsResource(AppContext appContext) {
        generator = appContext.getFizzBuzzGenerator();
    }

    @GET
    @Path("words")
    public List<String> words() {
        return generator.generateWords(20);
    }
}