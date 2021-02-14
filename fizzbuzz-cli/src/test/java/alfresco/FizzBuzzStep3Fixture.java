package alfresco;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Concordion will use this file to launch the fizzBuzzIt
 * method. This is the acceptance test.
 */
@RunWith(ConcordionRunner.class)
public class FizzBuzzStep3Fixture {

    private SystemCommand command;

    @Before
    public void before() {
        command = new SystemCommand();
    }

    /**
     * The method fizzBuzzIt is called by the specification defined
     * in the file alfresco/FizzBuzzStep1.md
     *
     * @param limit the
     * @return the output of the fizzbuzz app launched
     */
    public String fizzBuzzIt(String limit) {
        var result =
                command.run(
                        "java -cp target/classes:../fizzbuzz-domain/target/fizzbuzz-domain-1.0-SNAPSHOT.jar alfresco.FizzBuzzMain %s",
                        limit
                );

        assertThat(result.getExitValue())
                .as("the java application returned a non zero exit value")
                .as(result.getStderr())
                .isZero();

        return result.getStdout();
    }

}
