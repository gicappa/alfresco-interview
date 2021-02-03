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
        if (mutipleOf(number, 15)) {
            return "fizzbuzz";
        }

        if (mutipleOf(number, 3)) {
            return "fizz";
        }

        if (mutipleOf(number, 5)) {
            return "buzz";
        }

        return String.valueOf(number);
    }

    private boolean mutipleOf(int number, int i) {
        return number % i == 0;
    }
}
