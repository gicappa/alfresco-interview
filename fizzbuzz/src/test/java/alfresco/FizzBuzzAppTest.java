package alfresco;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Testing that the application is calling the FizzBuzz generate method
 */
class FizzBuzzAppTest {

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
        app = new FizzBuzzGeneratorUseCase(appContext);
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for rangeEnd times")
    void it_calls_the_fizzbuzz_rangeEnd_times() {
        app.mapNumberRangeToWords(20);

        verify(mockFizzBuzzMapper, times(20))
                .map(anyInt());
    }
    @Test
    @DisplayName("it calls the fizzbuzz generation for rangeEnd times")
    void it_calls_the_fizzbuzz_object_that_generates_a_report() {
        when(mockFizzBuzzMapper.map(anyInt())).thenReturn("1").thenReturn("2");

        app.mapNumberRangeToWords(2);

        verify(mockFizzBuzzReporter).report(List.of("1","2"));
    }

    @Test
    @DisplayName("It returns a List<String> containing words")
    void it_invokes_a_list_of_words() {
        assertThat(app.mapNumberRangeToWords(5)).hasSize(5);
    }

    @AfterEach
    public void afterEach() {
        reset(mockFizzBuzzMapper);
        reset(mockFizzBuzzReporter);

    }
}

