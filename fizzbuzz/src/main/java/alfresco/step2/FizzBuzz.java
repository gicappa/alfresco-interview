package alfresco.step2;

/**
 * The fizzbuzz generator takes an integer as an input and returns
 * a string as an output. It encodes the output string according to
 * specific rules.
 */
public class FizzBuzz {

    /**
     * Generate is the method that applies the rules of the fizzbuzz
     * to the input number generating the strings.
     *
     * @param number the input
     * @return the string computed on the rules applied to the input
     */
    public String generate(int number) {
        String result = "";

        result = new Rule(3, "fizz").apply(number, result);
        result = new Rule(5, "buzz").apply(number, result);

        if (String.valueOf(number).contains("3")) {
            result = "alfresco";
        }

        if (result.isBlank()) {
            result = String.valueOf(number);
        }

        return result;
    }

    static class Rule {
        private final int divisor;
        private final String word;

        Rule(int divisor, String word) {
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
        String apply(int number, String result) {
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
}
