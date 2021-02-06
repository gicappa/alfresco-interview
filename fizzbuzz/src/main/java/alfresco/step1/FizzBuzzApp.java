package alfresco.step1;

import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.joining;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class FizzBuzzApp {

    private final FizzBuzz fizzBuzz;

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

            new FizzBuzzApp(new FizzBuzz())
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
     * @param fizzBuzz collaborator that encodes numbers
     */
    public FizzBuzzApp(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
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
