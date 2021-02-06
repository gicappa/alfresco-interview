package alfresco.step2;

import alfresco.step1.FizzBuzz;
import alfresco.step1.FizzBuzzApp;
import alfresco.SystemCommand;
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
    private FizzBuzz mockFizzBuzz;
    private SystemCommand command;

    @BeforeEach
    void beforeEach() {
        mockFizzBuzz = mock(FizzBuzz.class);
        app = new FizzBuzzApp(mockFizzBuzz);
        command = new SystemCommand();
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for arg[0] times")
    void it_calls_the_fizzbuzz_arg_0_times() {
        app.generate(20);

        verify(mockFizzBuzz, times(20)).generate(anyInt());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "java -cp target/classes alfresco.step2.FizzBuzzApp",
            "java -cp target/classes alfresco.step2.FizzBuzzApp 1 2 3",
            "java -cp target/classes alfresco.step2.FizzBuzzApp blah"
    })
    @DisplayName("it displays usage when no number or while are passed")
    void it_prints_the_usage_when_no_args_are_passed(String cmdString) {
        var result =
                command.run(cmdString);

        assertThat(result.getExitValue()).isEqualTo(1);
        assertThat(result.getStderr()).contains("usage");
    }

}
