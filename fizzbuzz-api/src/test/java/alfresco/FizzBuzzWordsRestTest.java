package alfresco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class FizzBuzzWordsRestTest {
    private WordsResource fizzBuzzWords;
    private FizzBuzzGeneratorUseCase generator;

    @BeforeEach
    void beforeEach() {
        AppContext appContext = mock(AppContext.class);
        generator = mock(FizzBuzzGeneratorUseCase.class);
        when(appContext.getFizzBuzzGenerator()).thenReturn(generator);

        fizzBuzzWords = new WordsResource(appContext);
    }

    @Test
    @DisplayName("It calls the words generator")
    void it_calls_the_words_generator() {
        fizzBuzzWords.words();

        verify(generator).generateWords(20);
    }
}
