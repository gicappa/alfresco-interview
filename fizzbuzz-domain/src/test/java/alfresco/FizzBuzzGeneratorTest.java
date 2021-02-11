package alfresco;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Testing that the FizzBuzzGeneratorUseCase is properly
 * interacting with the FizzBuzzMapper.
 */
class FizzBuzzGeneratorTest {

    private FizzBuzzGeneratorUseCase app;
    private FizzBuzzMapper mockFizzBuzzMapper;
    private FizzBuzzReporterUseCase mockFizzBuzzReporter;

    @BeforeEach
    void beforeEach() {
        mockFizzBuzzMapper = mock(FizzBuzzMapper.class);
        mockFizzBuzzReporter = mock(FizzBuzzReporterUseCase.class);

        var appContext = mock(AppContext.class);
        when(appContext.getFizzBuzzMapper()).thenReturn(mockFizzBuzzMapper);
        when(appContext.getFizzBuzzReporter()).thenReturn(mockFizzBuzzReporter);
        app = new FizzBuzzGeneratorUseCase(mockFizzBuzzMapper);
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for rangeEnd times")
    void it_calls_the_fizzbuzz_rangeEnd_times() {
        app.generateWords(20);

        verify(mockFizzBuzzMapper, times(20))
                .map(anyInt());
    }

    @Test
    @DisplayName("It returns a Words containing Word")
    void it_generates_a_Words_object_containing_a_list_of_Word() {
        assertThat(app.generateWords(5)).isInstanceOf(Words.class);
    }

    @Test
    @DisplayName("It returns a List<String> containing words")
    void it_invokes_a_list_of_words() {
        assertThat(app.generateWords(5).getWords()).hasSize(5);
    }

    @AfterEach
    public void afterEach() {
        reset(mockFizzBuzzMapper);
        reset(mockFizzBuzzReporter);

    }
}

