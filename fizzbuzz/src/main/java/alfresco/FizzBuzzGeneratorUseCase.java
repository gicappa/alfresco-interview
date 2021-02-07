package alfresco;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * This use case can generate a list of fizz buzz words
 */
public class FizzBuzzGeneratorUseCase {

    private final FizzBuzzMapper fizzBuzzMapper;

    /**
     * @param appContext context to wire and create collaborators
     */
    public FizzBuzzGeneratorUseCase(AppContext appContext) {
        this.fizzBuzzMapper = appContext.getFizzBuzzMapper();
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
