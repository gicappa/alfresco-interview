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

        result = new Rule().apply(number, result);

        if (multipleOf(number, 5)) {
            result += "buzz";
        }

        if (String.valueOf(number).contains("3")) {
            result = "alfresco";
        }

        if (result.isBlank()) {
            result = String.valueOf(number);
        }

        return result;
    }

    /**
     * @param number  the number to be checked
     * @param divider the divider to be checked
     * @return true if number is a multiple of divider
     */
    private boolean multipleOf(int number, int divider) {
        return number % divider == 0;
    }

    class Rule {
        String apply(int number, String result) {
            if (multipleOf(number, 3)) {
                result += "fizz";
            }
            return result;
        }
    }
}
