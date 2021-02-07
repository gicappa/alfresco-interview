package alfresco;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Testing that the application is calling the FizzBuzz generate method
 */
class FizzBuzzAppTest {

    private FizzBuzzApp app;
    private FizzBuzzIt mockFizzBuzzIt;

    @BeforeEach
    void beforeEach() {
        mockFizzBuzzIt = mock(FizzBuzzIt.class);

        var appContext = mock(AppContext.class);
        when(appContext.getFizzBuzzIt()).thenReturn(mockFizzBuzzIt);
        app = new FizzBuzzApp(appContext);
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for arg[0] times")
    void it_calls_the_fizzbuzz_arg_0_times() {
        app.fizzBuzzIt(20);

        verify(mockFizzBuzzIt, times(20)).generate(anyInt());
    }

    @Test
    @DisplayName("")
    void it_returns_a_list_of_words() {
//        assertThat(app.generate(10))
    }
}
