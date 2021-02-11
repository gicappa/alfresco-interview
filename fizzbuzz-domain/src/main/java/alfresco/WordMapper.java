package alfresco;

import java.util.List;

/**
 * The fizzbuzz generator takes an integer as an input and returns
 * a string as an output. It encodes the output string according to
 * specific rules.
 */
public class WordMapper {

    private final List<Rule> rules;

    WordMapper(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * The map() method translates a number into a fizzbuzz word.
     * The translation happens according to a list of rules that
     * are passed to the mapper class.
     *
     * @param number the input
     * @return the string computed on the rules applied to the input
     */
    public String map(int number) {
        String result = "";

        for (Rule rule : rules) {
            result = rule.apply(number, result);
        }

        return result;
    }
}
