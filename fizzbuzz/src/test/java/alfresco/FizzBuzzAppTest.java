package alfresco;


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

    private FizzBuzzApp app;
    private FizzBuzzIt mockFizzBuzzIt;
    private FizzBuzzReporter mockFizzBuzzReporter;

    @BeforeEach
    void beforeEach() {
        mockFizzBuzzIt = mock(FizzBuzzIt.class);
        mockFizzBuzzReporter = mock(FizzBuzzReporter.class);

        var appContext = mock(AppContext.class);
        when(appContext.getFizzBuzzIt()).thenReturn(mockFizzBuzzIt);
        when(appContext.getFizzBuzzReporter()).thenReturn(mockFizzBuzzReporter);
        app = new FizzBuzzApp(appContext);
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for rangeEnd times")
    void it_calls_the_fizzbuzz_rangeEnd_times() {
        app.fizzBuzzIt(20);

        verify(mockFizzBuzzIt, times(20))
                .generate(anyInt());
    }
    @Test
    @DisplayName("it calls the fizzbuzz generation for rangeEnd times")
    void it_calls_the_fizzbuzz_object_that_generates_a_report() {
        when(mockFizzBuzzIt.generate(anyInt())).thenReturn("1").thenReturn("2");

        app.fizzBuzzIt(2);

        verify(mockFizzBuzzReporter).report(List.of("1","2"));
    }

    @Test
    @DisplayName("It returns a List<String> containing words")
    void it_invokes_a_list_of_words() {
        assertThat(app.fizzBuzzIt(5)).hasSize(5);
    }
}
