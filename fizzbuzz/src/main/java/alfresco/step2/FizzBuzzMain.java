package alfresco.step2;

import static java.lang.Integer.parseInt;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class FizzBuzzMain {

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


            new FizzBuzzApp(new AppContext())
                    .generate(parseInt(args[0]));

        } catch (Exception e) {
            printUsageAndExit();
        }
    }

    private static void printUsageAndExit() {
        System.err.println("usage: java alfresco.FizzBuzzApp <number of fizzbuzz generation>");
        System.exit(1);
    }
}
