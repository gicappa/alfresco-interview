package alfresco;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AppTest {

    @Test
    @DisplayName("The application must call the fizzbuzz producer with the number from 1 to arg[0]")
    void it_calls_the_fizzbuzz_arg_0_times() {
        var mockFizzBuzz = mock(FizzBuzz.class);



        var app = new App(mockFizzBuzz);

        app.generate(20);

        verify(mockFizzBuzz, times(20)).generate(anyInt());
    }
}
