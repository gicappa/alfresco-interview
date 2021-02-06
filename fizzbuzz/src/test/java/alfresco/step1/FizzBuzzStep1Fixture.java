package alfresco.step1;

import alfresco.SystemCommand;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Concordion will use this file to launch the fizzBuzzIt
 * method. This is the acceptance test.
 */
@RunWith(ConcordionRunner.class)
public class FizzBuzzStep1Fixture {

    private SystemCommand command;

    @Before
    public void before() {
        command = new SystemCommand();
    }

    /**
     * The method fizzBuzzIt is called by the specification defined
     * in the file alfresco/FizzBuzzStep1.md
     *
     * @param rangeEnd the
     * @return the output of the fizzbuzz app launched
     */
    public String fizzBuzzIt(String rangeEnd) {
        var result =
                command.run("java -cp target/classes alfresco.step1.FizzBuzzApp %s", rangeEnd);

        assertThat(result.getExitValue()).isZero();

        return result.getStdout();
    }

}
