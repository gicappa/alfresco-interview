package alfresco.step2;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class FizzBuzzApp {

    private final FizzBuzzIt fizzBuzz;

    /**
     * @param appContext context to wire and create collaborators
     */
    public FizzBuzzApp(AppContext appContext) {
        this.fizzBuzz = appContext.getFizzBuzzIt();
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
