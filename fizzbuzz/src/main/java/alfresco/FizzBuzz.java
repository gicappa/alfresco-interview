package alfresco;

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

        if (mutipleOf(number, 15)) {
            result = "fizzbuzz";
        } else if (mutipleOf(number, 3)) {
            result = "fizz";
        } else if (mutipleOf(number, 5)) {
            result = "buzz";
        }

        return result.isBlank() ? String.valueOf(number) : result;
    }

    private boolean mutipleOf(int number, int i) {
        return number % i == 0;
    }
}
