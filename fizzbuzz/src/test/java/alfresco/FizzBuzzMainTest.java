package alfresco;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
