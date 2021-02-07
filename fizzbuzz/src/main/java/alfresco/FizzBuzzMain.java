package alfresco;

/**
 * The fizz buzz app prints out a series of numbers
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
        try {

            if (args.length != 1) {
                printUsageAndExit();
            }

            generate(Integer.parseInt(args[0]));

        } catch (Exception e) {
            printUsageAndExit();
        }
    }

    /**
     * Print all the fizz buzz values in a range
     *
     * @param rangeEnd end number of the range
     */
    public static void generate(int rangeEnd) {
        var app = new FizzBuzzApp(new AppContext.CliAppContext());

        System.out.println(app.generatesFizzBuzzUpTo(rangeEnd));
    }


    private static void printUsageAndExit() {
        System.err.println(
                "usage: java alfresco.FizzBuzzApp [arg]\n" +
                        "   arg - (required) number of fizzbuzz words to generate");
        System.exit(1);
    }
}
