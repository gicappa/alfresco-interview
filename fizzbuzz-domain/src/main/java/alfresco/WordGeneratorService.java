package alfresco;

import java.util.stream.IntStream;

import alfresco.words.WordMapper;
import alfresco.words.Words;

import static alfresco.words.WordsCollector.toWords;

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
     * @param limit is the upper bound of the range
     * @return a string containing the generated values
     * @throws LimitMinorThanOneEx unchecked exception thrown for argument
     *                             values minor than 1
     */
    public Words generateWords(int limit) {
        if (limit < 1) {
            throw new LimitMinorThanOneEx();
        }

        return IntStream.rangeClosed(1, limit)
            .mapToObj(fizzBuzzMapper::map)
            .collect(toWords());

    }
}
