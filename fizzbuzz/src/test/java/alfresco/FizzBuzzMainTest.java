package alfresco;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing that the application is calling the FizzBuzz generate method
 */
class FizzBuzzMainTest {

    private SystemCommand command;

    @BeforeEach
    void beforeEach() {
        command = new SystemCommand();
    }

    @ParameterizedTest
    @CsvSource({
            "java -cp target/classes alfresco.FizzBuzzMain,       128",
            "java -cp target/classes alfresco.FizzBuzzMain 1 2 3, 128",
            "java -cp target/classes alfresco.FizzBuzzMain blah,  1"
    })
    @DisplayName("it displays usage when no number or while are passed")
    void it_prints_the_usage_when_no_args_are_passed(String cmdString, int exitValue) {
        var result =
                command.run(cmdString);

        assertThat(result.getExitValue()).isEqualTo(exitValue);
        assertThat(result.getStderr()).contains("usage");
    }

}
