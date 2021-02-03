package alfresco;

import org.concordion.api.ExpectedToFail;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.runner.RunWith;

import java.io.IOException;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ConcordionRunner.class)
public class FizzBuzzStep1Fixture {

    // Contains the standard output of the fizzbuzz application
    private String stdout;

    public String fizzBuzzIt(String end) {
        int exit = run(
                format("java -cp target/classes alfresco.App %s", end));

        assertThat(exit).isZero();

        return stdout;
    }

    /**
     * Run a process launching a command. It waits for the command to
     * complete and returns its exit code.
     * It also records the standard output in the field `stdout`
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

    // clean up of the gathered standard output
    @After
    public void after() {
        stdout = null;
    }
}
