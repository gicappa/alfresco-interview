package alfresco;

import static java.lang.Integer.parseInt;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class FizzBuzzMain {

    /**
     * Entry point of the Application.
     *
     * If the caller doesn't pass one argument, it displays
     * the usage of the application on the standard error.
     *
     * @param args number of fizz buzz element to generate
     */
    public static void main(String... args) {
        try {

            if (args.length != 1) {
                printUsageAndExit();
            }

            new FizzBuzzApp(new AppContext.CliAppContext())
                    .generate(parseInt(args[0]));

        } catch (Exception e) {
            printUsageAndExit();
        }
    }

    private static void printUsageAndExit() {
        System.err.println(
                "usage: java alfresco.FizzBuzzApp [arg]\n" +
                        "   arg - (required) number of fizzbuzz words to generate");
        System.exit(1);
    }
}
