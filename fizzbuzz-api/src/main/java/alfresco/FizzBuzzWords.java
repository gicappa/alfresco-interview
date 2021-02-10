package alfresco;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Produces("application/json")
public class FizzBuzzWords {

    @GET
    @Path("words")
    public Words words() {
        return new Words();
    }
}