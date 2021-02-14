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
    @DisplayName("It returns a Words from the generator")
    void it_returns_the_words_from_the_generator_in_a_list() {

        assertThat(wordsResource.words("3")).isInstanceOf(Response.class);
    }

    @Test
    @DisplayName("It calls the words generator")
    void it_calls_the_words_generator() {

        verify(generator).generateWords(3);
    }

    @Test
    @DisplayName("It returns a Words from the generator")
    void it_returns_the_words_generated_by_the_generator() {

        assertThat(wordsResponse.getWords()).containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("It returns a Words from the generator")
    void it_returns_the_limit_set_by_the_caller() {

        assertThat(wordsResponse.getLimit()).isEqualTo(3);
    }

    @Test
    @DisplayName("It returns a Words from the generator")
    void it_returns_the_error_response_when_limits_is_not_a_number() {
        var errorResponse = wordsResource.words("not-a-number").readEntity(ErrorReponse.class);

         assertThat(errorResponse.getError().getCode()).isEqualTo("FB001");
         assertThat(errorResponse.getError().getType()).isEqualTo("ValidationError");
         assertThat(errorResponse.getError().getMessage()).contains("limit");
    }

}
