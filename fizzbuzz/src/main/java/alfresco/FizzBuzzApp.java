package alfresco;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class FizzBuzzApp {

    private final FizzBuzzIt fizzBuzzIt;
    private final FizzBuzzReporter fizzBuzzReporter;

    /**
     * @param appContext context to wire and create collaborators
     */
    public FizzBuzzApp(AppContext appContext) {
        this.fizzBuzzIt = appContext.getFizzBuzzIt();
        this.fizzBuzzReporter = appContext.getFizzBuzzReporter();
    }

    /**
     * Generates all fizz buzz values up to a range limit
     *
     * @param rangeEnd end number of the range
     * @return a string containing the generated values
     */
    public List<String> fizzBuzzIt(int rangeEnd) {
        var fizzBuzzWords =
                IntStream.rangeClosed(1, rangeEnd)
                        .mapToObj(fizzBuzzIt::generate)
                        .collect(toList());

        Map<String, Long> report = fizzBuzzReporter.report(fizzBuzzWords);

        return fizzBuzzWords;

    }
}
