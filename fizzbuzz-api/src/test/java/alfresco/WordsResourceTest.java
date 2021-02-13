package alfresco;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class WordsResourceTest {

    /**
     * Checking that the apis are returning a JSON with a list of
     * words. The number of words is by default 20 and they must
     * comply with the fizzbuzz specification.
     */
    @Test
    void it_calls_words_resource_without_parameter() {
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

    /**
     * Checking that the apis are returning a JSON with a list of
     * words. The number of words is by default 20 and they must
     * comply with the fizzbuzz specification.
     */
    @Test
    void it_calls_words_resource_with_a_parameter() {
        given()
            .queryParam("limit", "15")
            .when()
            .get("/words")
            .then()
            .statusCode(200)
            .contentType(JSON)
            .body("words",
                hasSize(15))
            .body("words", hasItems("1", "2", "alfresco", "4", "buzz",
                "fizz", "7", "8", "fizz", "buzz", "11", "fizz",
                "alfresco", "14", "fizzbuzz"));
    }

    /**
     * To better express the error that occurred we may expect a response
     * Similar to this one.
     * <p>
     * {
     *   "error": {
     *     "type": "ValidationError",
     *     "code": "FB001",
     *     "message": "The query parameter limit must be a number.",
     *   }
     * }
     */
    @Test
    void it_calls_words_resource_with_a_wrong_parameter() {
        System.out.println(given()
            .queryParam("limit", "foobar")
            .when()
            .get("/words")
            .then()
            .statusCode(400)
            .contentType(JSON)
            .body("any { it.key == 'error' }", is(true))
            .body("error.type", is("ValidationError"))
            .body("error.code", is("FB001"))
            .body("error.message", containsString("limit must be a number"))
        );

    }
}