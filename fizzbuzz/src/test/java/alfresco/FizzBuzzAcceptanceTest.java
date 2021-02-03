package alfresco;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzAcceptanceTest {

    String stdout;

    /**
     * This is the acceptance test of the fizzbuzz application.
     * The test verifies that launching the application with an
     * argument it returns the desired output.
     */
    @Test
    @DisplayName("Acceptance test for the fizzbuzz application")
    void it_launches_the_application() {
        int exit = run("java -cp target/classes alfresco.App 20");

        assertThat(exit).isZero();

        assertThat(stdout).isEqualTo("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz");
    }

    /**
     * Run a process launching a command. It waits for the command to
     * complete and returns its exit code.
     *
     * @param command to be launched
     * @return the exit code of the command execution
     * @throws RuntimeException the command can be invalid
     */
    private int run(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            stdout = new String(process.getInputStream().readAllBytes());
            return process.exitValue();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
