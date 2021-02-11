package alfresco;

import java.util.stream.IntStream;

import static alfresco.WordsCollector.toWords;

/**
 * This use case can generate a list of fizz buzz words
 */
public class WordGeneratorService {

    private final WordMapper fizzBuzzMapper;

    /**
     * @param fizzBuzzMapper the collaborator to map number into words
     */
    public WordGeneratorService(WordMapper fizzBuzzMapper) {
        this.fizzBuzzMapper = fizzBuzzMapper;
    }

    /**
     * Generates all fizz buzz values up to a range limit
     *
     * @param rangeEnd end number of the range
     * @return a string containing the generated values
     */
    public Words generateWords(int rangeEnd) {
        return IntStream.rangeClosed(1, rangeEnd)
                .mapToObj(fizzBuzzMapper::map)
                .collect(toWords());

    }
}
