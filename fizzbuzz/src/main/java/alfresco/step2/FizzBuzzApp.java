package alfresco.step2;

import alfresco.step2.rules.ContainsDigitRule;
import alfresco.step2.rules.DivisorRule;
import alfresco.step2.rules.ToStringRule;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.joining;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class FizzBuzzApp {

    private final FizzBuzzIt fizzBuzz;

    /**
     * Entry point of the Application.
     *
     * @param args number of fizz buzz element to generate
     */
    public static void main(String... args) {
        try {

            if (args.length != 1) {
                printUsageAndExit();
            }

            List<Rule> rules = List.of(new DivisorRule(3, "fizz"),
                    new DivisorRule(5, "buzz"),
                    new ContainsDigitRule(3, "alfresco"),
                    new ToStringRule());

            new FizzBuzzApp(new FizzBuzzIt(rules))
                    .generate(parseInt(args[0]));

        } catch (Exception e) {
            printUsageAndExit();
        }
    }

    private static void printUsageAndExit() {
        System.err.println("usage: java alfresco.FizzBuzzApp <number of fizzbuzz generation>");
        System.exit(1);
    }

    /**
     * @param fizzBuzzIt collaborator that encodes numbers
     */
    public FizzBuzzApp(FizzBuzzIt fizzBuzzIt) {
        this.fizzBuzz = fizzBuzzIt;
    }

    /**
     * Print all the fizz buzz values in a range
     *
     * @param rangeEnd end number of the range
     */
    public void generate(int rangeEnd) {
        System.out.println(generatesFizzBuzzUpTo(rangeEnd));
    }

    /**
     * Generates all fizz buzz values up to a range limit
     *
     * @param rangeEnd end number of the range
     * @return a string containing the generated values
     */
    private String generatesFizzBuzzUpTo(int rangeEnd) {
        return IntStream.rangeClosed(1, rangeEnd)
                .mapToObj(fizzBuzz::generate)
                .collect(joining(" "));
    }
}
