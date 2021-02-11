package alfresco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class FizzBuzzWordsRestTest {
    private WordsResource fizzBuzzWords;
    private FizzBuzzGeneratorUseCase generator;

    @BeforeEach
    void beforeEach() {
        AppContext appContext = mock(AppContext.class);
        generator = mock(FizzBuzzGeneratorUseCase.class);
        when(appContext.getFizzBuzzGenerator()).thenReturn(generator);
        when(generator.generateWords(20)).thenReturn(Words.of("a", "b", "c"));

        fizzBuzzWords = new WordsResource(appContext);
    }

    @Test
    @DisplayName("It calls the words generator")
    void it_calls_the_words_generator() {
        fizzBuzzWords.words();

        verify(generator).generateWords(20);
    }

    @Test
    @DisplayName("It returns a Words from the generator")
    void it_returns_the_words_from_the_generator_in_a_list() {
        assertThat(fizzBuzzWords.words()).isInstanceOf(Words.class);
    }

    @Test
    @DisplayName("It returns a Words from the generator")
    void it_returns_the_words_generated_by_the_generator() {
        assertThat(fizzBuzzWords.words().getWords()).containsExactly("a", "b", "c");
    }
}
