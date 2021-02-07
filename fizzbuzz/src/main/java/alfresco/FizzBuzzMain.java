package alfresco;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import static java.util.stream.Collectors.joining;

/**
 * The fizz buzz app translates a number range into a
 * series of strings that may be containing a number
 * or a special word (fizz, buzz, etc.) according to
 * certain rules.
 */
public class FizzBuzzMain {

    /**
     * Entry point of the Application.
     * <p>
     * If the caller doesn't pass one argument, it displays
     * the usage of the application on the standard error.
     *
     * @param args number of fizz buzz element to generate
     */
    public static void main(String... args) {
        new FizzBuzzMain().run(args);
    }

    public void run(String... args) {
        try {

            if (args.length != 1) {
                printUsage();
                exit(128); // Invalid argument
            }

            var app = new FizzBuzzApp(new CliAppContext());

            printResults(app.mapNumberRangeToWords(parseInt(args[0])));

        } catch (Exception e) {
            printUsage();
            exit(1); // Generic error
        }
    }

    /**
     * Print all the fizz buzz values in a range
     *
     * @param results the result of the application execution
     */
    public void printResults(List<String> results) {
        System.out.println(String.join(" ", results));
    }

    /**
     * Help message in case of an error
     */
    private void printUsage() {
        System.err.println(
                "usage: java alfresco.FizzBuzzMain [arg]\n" +
                        "   arg - (required) number of fizzbuzz words to generate");
    }
}
