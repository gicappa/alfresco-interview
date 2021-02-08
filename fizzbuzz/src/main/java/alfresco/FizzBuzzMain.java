package alfresco;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.String.join;
import static java.lang.System.exit;
import static java.util.stream.Collectors.toList;

/**
 * The fizz buzz app translates a number range into a
 * series of strings that may be containing a number
 * or a special word (fizz, buzz, etc.) according to
 * certain rules.
 */
public class FizzBuzzMain {

    private final FizzBuzzGeneratorUseCase generator;
    private final FizzBuzzReporterUseCase report;

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

    public FizzBuzzMain() {
        this(new DefaultAppContext());
    }

    public FizzBuzzMain(AppContext appContext) {
        this.generator = appContext.getFizzBuzzGenerator();
        this.report = appContext.getFizzBuzzReporter();
    }

    public void run(String... args) {
        try {

            if (args.length != 1) {
                printUsage();
                exit(128); // Invalid argument
            }

            var results = generator.generateWords(parseInt(args[0]));

            printOutput(results, computeReport(report.report(results)));

        } catch (Exception e) {
            printUsage();
            exit(1); // Generic error
        }
    }

    /**
     * @param reports the result of the application execution
     * @return the string with all the fizzbuzz
     */
    public List<String> computeReport(Map<String, Long> reports) {
        return Stream.of("fizz", "buzz", "fizzbuzz", "alfresco", "integer")
                .filter(reports::containsKey)
                .map(r -> r + ": " + reports.get(r))
                .collect(toList());
    }

    /**
     * Print all the fizz buzz values in a range
     *
     * @param results the result of the application execution
     */
    public void printOutput(List<String> results, List<String> reports) {
        System.out.println(
                join(" ", results) + " " + join(" ", reports)
        );
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
