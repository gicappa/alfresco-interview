package alfresco;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class FizzBuzzApp {

    private final FizzBuzzIt fizzBuzzIt;

    /**
     * @param appContext context to wire and create collaborators
     */
    public FizzBuzzApp(AppContext appContext) {
        this.fizzBuzzIt = appContext.getFizzBuzzIt();
    }

    /**
     * Generates all fizz buzz values up to a range limit
     *
     * @param rangeEnd end number of the range
     * @return a string containing the generated values
     */
    public String fizzBuzzIt(int rangeEnd) {
        return IntStream.rangeClosed(1, rangeEnd)
                .mapToObj(fizzBuzzIt::generate)
                .collect(joining(" "));
    }
}
