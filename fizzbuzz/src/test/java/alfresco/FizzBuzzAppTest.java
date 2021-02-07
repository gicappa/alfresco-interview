package alfresco;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Testing that the application is calling the FizzBuzz generate method
 */
class FizzBuzzAppTest {

    private FizzBuzzApp app;
    private FizzBuzzIt mockFizzBuzzIt;
    private SystemCommand command;

    @BeforeEach
    void beforeEach() {
        mockFizzBuzzIt = mock(FizzBuzzIt.class);

        var appContext = mock(AppContext.class);
        when(appContext.getFizzBuzzIt()).thenReturn(mockFizzBuzzIt);
        app = new FizzBuzzApp(appContext);

        command = new SystemCommand();
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for arg[0] times")
    void it_calls_the_fizzbuzz_arg_0_times() {
        app.generate(20);

        verify(mockFizzBuzzIt, times(20)).generate(anyInt());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "java -cp target/classes alfresco.FizzBuzzMain",
            "java -cp target/classes alfresco.FizzBuzzMain 1 2 3",
            "java -cp target/classes alfresco.FizzBuzzMain blah"
    })
    @DisplayName("it displays usage when no number or while are passed")
    void it_prints_the_usage_when_no_args_are_passed(String cmdString) {
        var result =
                command.run(cmdString);

        assertThat(result.getExitValue()).isEqualTo(1);
        assertThat(result.getStderr()).contains("usage");
    }

}
