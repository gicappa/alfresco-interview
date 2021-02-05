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

    @Test
    @DisplayName("it displays usage when no args are passed")
    void it_prints_the_usage_when_no_args_are_passed() {
        var result =
                command.run("java -cp target/classes alfresco.FizzBuzzApp");

        assertThat(result.getExitValue()).isEqualTo(1);
        assertThat(result.getStderr()).contains("usage");
    }

    @Test
    @DisplayName("it displays usage when no args are passed")
    void it_prints_the_usage_when_more_than_one_arg_is_passed() {
        var result =
                command.run("java -cp target/classes alfresco.FizzBuzzApp 1 2 3");

        assertThat(result.getExitValue()).isEqualTo(1);
        assertThat(result.getStderr()).contains("usage");
    }

    @Test
    @DisplayName("it displays usage when no args are passed")
    void it_prints_the_usage_when_a_invalid_number_arg_is_passed() {
        var result =
                command.run("java -cp target/classes alfresco.FizzBuzzApp blah");

        assertThat(result.getExitValue()).isEqualTo(1);
        assertThat(result.getStderr()).contains("usage");
    }
}
