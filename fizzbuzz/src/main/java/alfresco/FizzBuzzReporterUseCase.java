package alfresco;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * This class can create reports counting the usage of
 * the words in fizzbuzz word list
 */
public class FizzBuzzReporterUseCase {

    /**
     * Analyse the word list in input to create a map containing
     * as keys the words and as values the occurrences of the word
     *
     * @param words a list of fizzbuzz words
     * @return a map with the words and their occurrences
     */
    public Map<String, Long> report(List<String> words) {
        return words.stream()
                .map(this::toInteger)
                .collect(groupingBy(identity(), counting()));
    }

    /**
     * @param word a fizzbuzz word
     * @return the same word or the string 'integer' in case
     * the fizzbuzz word is a number
     */
    public String toInteger(String word) {
        try {
            parseInt(word);
            return "integer";
        } catch (NumberFormatException nfe) {
            return word;
        }
    }
}
