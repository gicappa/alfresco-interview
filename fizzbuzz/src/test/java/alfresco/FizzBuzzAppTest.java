package alfresco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Testing that the application is calling the FizzBuzz generate method
 */
class FizzBuzzAppTest {

    private FizzBuzz mockFizzBuzz;
    private FizzBuzzApp app;

    @BeforeEach
    void beforeEach() {
        mockFizzBuzz = mock(FizzBuzz.class);
        app = new FizzBuzzApp(mockFizzBuzz);
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for arg[0] times")
    void it_calls_the_fizzbuzz_arg_0_times() {
        app.generate(20);

        verify(mockFizzBuzz, times(20)).generate(anyInt());
    }
}
