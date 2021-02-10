package alfresco;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(

        info = @Info(
                title = "FizzBuzz Exercise",
                version = "4.0.0",
                description = "FizzBuzz Exercise for Alfresco Coding Interview",
                contact = @Contact(
                        name = "Gian Carlo Pace",
                        url = "http://giancarlopace.com",
                        email = "giancarlo.pace@gmail.com"),
                license = @License(
                        name = "BSD-3-Clause",
                        url = "https://opensource.org/licenses/BSD-3-Clause")),
        tags = {
                @Tag(name = "words", description = "A FizzBuzz word is a " +
                        "string that results from the mapping of a number " +
                        "into a string after applying all the fizzbuzz rules."),
        }
)
@SuppressWarnings("unused")
public class FizzBuzzApplication extends Application {
}
