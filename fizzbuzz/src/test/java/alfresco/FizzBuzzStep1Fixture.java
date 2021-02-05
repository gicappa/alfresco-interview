package alfresco;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ConcordionRunner.class)
public class FizzBuzzStep1Fixture {

    private SystemCommand command;

    /**
     * The method fizzBuzzIt is called by the specification defined
     * in the file alfresco/FizzBuzzStep1.md
     *
     * @param rangeEnd the
     * @return the output of the fizzbuzz app launched
     */
    public String fizzBuzzIt(String rangeEnd) {
        int exit = command.run("java -cp target/classes alfresco.FizzBuzzApp %s", rangeEnd);

        assertThat(exit).isZero();

        return command.getStdout();
    }

    @Before
    public void before() {
        command = new SystemCommand();
    }

    @After
    public void after() {
        command.clearStderr();
        command.clearStdout();
    }
}
