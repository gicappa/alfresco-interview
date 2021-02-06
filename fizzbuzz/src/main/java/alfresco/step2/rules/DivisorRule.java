package alfresco.step2.rules;

import alfresco.step2.Rule;

/**
 * The rule is applied when the number passed
 * is a divisor of the number.
 *
 * If the rule is matched the result is returned
 * with an additional special word in it.
 */
public class DivisorRule implements Rule {

    private final int divisor;
    private final String word;

    public DivisorRule(int divisor, String word) {
        this.divisor = divisor;
        this.word = word;
    }

    /**
     * Apply the rule to the number
     *
     * @param number to be parsed
     * @param result the result coming from the previous rules
     * @return the result with the applied rules
     */
    public String apply(int number, String result) {
        return result + translate(number);
    }

    private String translate(int number) {
        if (multipleOf(number, divisor))
            return word;

        return "";
    }

    /**
     * @param number  the number to be checked
     * @param divider the divider to be checked
     * @return true if number is a multiple of divider
     */
    private boolean multipleOf(int number, int divider) {
        return number % divider == 0;
    }
}
