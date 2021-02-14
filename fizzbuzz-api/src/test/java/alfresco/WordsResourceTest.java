package alfresco;

import alfresco.words.Words;
import alfresco.words.WordsResource;
import alfresco.words.WordsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WordsResourceTest {

    private WordsResource wordsResource;
    private WordGeneratorService generator;
    private WordsResponse wordsResponse;

    @BeforeEach
    void beforeEach() {
        AppContext appContext = mock(AppContext.class);
        generator = mock(WordGeneratorService.class);
        when(appContext.getFizzBuzzGenerator()).thenReturn(generator);
        when(generator.generateWords(3)).thenReturn(Words.of("a", "b", "c"));
        wordsResource = new WordsResource(appContext);

        wordsResponse = wordsResource.words("3").readEntity(WordsResponse.class);
    }

    @Test
    @DisplayName("It returns a Response object from the WordsResource")
    void it_returns_the_response_object_from_WordsResource() {

        assertThat(wordsResource.words("3")).isInstanceOf(Response.class);
    }

    @Test
    @DisplayName("It calls the words generator")
    void it_calls_the_words_generator() {

        verify(generator).generateWords(3);
    }

    @Test
    @DisplayName("It returns a WordsResponse object containing fizzbuzz generated strings")
    void it_returns_a_Words_object_containing_strings() {

        assertThat(wordsResponse.getWords()).containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("It returns a WordsResponse containing the limit used as argument")
    void it_returns_a_WordResponse_limit_argument() {

        assertThat(wordsResponse.getLimit()).isEqualTo(3);
    }

    @Test
    @DisplayName("It returns an ErrorResponse when limit is NaN")
    void it_returns_an_ErrorResponse_when_limit_is_NaN() {
        var errorResponse = wordsResource.words("not-a-number").readEntity(ErrorReponse.class);

        assertThat(errorResponse.getError().getCode()).isEqualTo("FB001");
        assertThat(errorResponse.getError().getType()).isEqualTo("ValidationError");
        assertThat(errorResponse.getError().getMessage()).contains("limit");
    }

    @Test
    @DisplayName("It returns an ErrorResponse when limit is minor than one")
    void it_returns_the_error_response_when_limits_is_not_a_number() {
        when(generator.generateWords(-1)).thenThrow(LimitMinorThanOneEx.class);

        var errorResponse = wordsResource.words("-1")
            .readEntity(ErrorReponse.class);

        assertThat(errorResponse.getError().getCode()).isEqualTo("FB002");
        assertThat(errorResponse.getError().getType()).isEqualTo("ValidationError");
        assertThat(errorResponse.getError().getMessage()).contains("greater");
    }
}
