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

        result = new DivisorRule(3, "fizz").apply(number, result);
        result = new DivisorRule(5, "buzz").apply(number, result);

        if (String.valueOf(number).contains("3")) {
            result = "alfresco";
        }

        if (result.isBlank()) {
            result = String.valueOf(number);
        }

        return result;
    }

}
