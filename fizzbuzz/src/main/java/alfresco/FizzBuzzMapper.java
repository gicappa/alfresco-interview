package alfresco;

import java.util.List;

/**
 * The fizzbuzz generator takes an integer as an input and returns
 * a string as an output. It encodes the output string according to
 * specific rules.
 */
public class FizzBuzzMapper {

    private final List<Rule> rules;

    FizzBuzzMapper(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * Generate is the method that applies the rules of the fizzbuzz
     * to the input number generating the strings.
     *
     * @param number the input
     * @return the string computed on the rules applied to the input
     */
    public String generate(int number) {
        String result = "";

        for (Rule rule : rules) {
            result = rule.apply(number, result);
        }

        return result;
    }
}
