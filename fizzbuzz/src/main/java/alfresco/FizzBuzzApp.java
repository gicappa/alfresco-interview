package alfresco;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class FizzBuzzApp {

    private final FizzBuzzMapper fizzBuzzMapper;
    private final FizzBuzzReporter fizzBuzzReporter;

    /**
     * @param appContext context to wire and create collaborators
     */
    public FizzBuzzApp(AppContext appContext) {
        this.fizzBuzzMapper = appContext.getFizzBuzzMapper();
        this.fizzBuzzReporter = appContext.getFizzBuzzReporter();
    }

    /**
     * Generates all fizz buzz values up to a range limit
     *
     * @param rangeEnd end number of the range
     * @return a string containing the generated values
     */
    public List<String> mapNumberRangeToWords(int rangeEnd) {
        return IntStream.rangeClosed(1, rangeEnd)
                .mapToObj(fizzBuzzMapper::map)
                .collect(toList());

    }
}
