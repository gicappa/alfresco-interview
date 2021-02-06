package alfresco.step2;

import alfresco.step2.rules.ContainsDigitRule;
import alfresco.step2.rules.DivisorRule;
import alfresco.step2.rules.ToStringRule;

import java.util.List;

/**
 * The fizzbuzz generator takes an integer as an input and returns
 * a string as an output. It encodes the output string according to
 * specific rules.
 */
public class FizzBuzzIt {

    List<Rule> rules = List.of(new DivisorRule(3, "fizz"),
            new DivisorRule(5, "buzz"),
            new ContainsDigitRule(3, "alfresco"),
            new ToStringRule());

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
