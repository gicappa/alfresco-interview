package alfresco.words.rules;

import alfresco.words.Rule;

/**
 * The {BaseRule} is applied when the result is not valued
 * and it just transform the number in a string.
 */
public class BaseRule implements Rule {

    /**
     * Apply the rule to the number
     *
     * @param number to be parsed
     * @param result the result coming from the previous rules
     * @return the result with the applied rules
     */
    public String apply(int number, String result) {
        return result.isBlank() ? String.valueOf(number) : result;
    }
}
