package alfresco;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.hasItems;

@QuarkusTest
class WordsResourceTest {

    /**
     * Checking that the apis are returning a JSON with a list of
     * words. The number of words is by default 20 and they must
     * comply with the fizzbuzz specification.
     */
    @Test
//    @Disabled("Feature in progress")
    void test() {
        given()
                .when()
                .get("/words")
                .then()
                .statusCode(200)
                .contentType(JSON)
                .body("words",
                        hasItems("1", "2", "alfresco", "4", "buzz",
                                "fizz", "7", "8", "fizz", "buzz", "11", "fizz",
                                "alfresco", "14", "fizzbuzz", "16", "17", "fizz",
                                "19", "buzz"));
    }

}