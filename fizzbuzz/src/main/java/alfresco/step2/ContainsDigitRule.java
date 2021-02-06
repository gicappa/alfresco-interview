package alfresco.step2;

/**
 * The ContainsRule is meant to substitute a the result
 * with a specific string if the number contains a
 * certain digit.
 */
public class ContainsDigitRule {

    private final int digit;
    private final String word;

    ContainsDigitRule(int digit, String word) {
        this.digit = digit;
        this.word = word;
    }

    /**
     * Apply the rule to the number
     *
     * @param number to be parsed
     * @param result the result coming from the previous rules
     * @return the result with the applied rules
     */
    String apply(int number, String result) {
        if (str(number).contains(str(digit))) {
            return word;
        }

        return result;
    }

    private String str(int digit) {
        return String.valueOf(digit);
    }

}
