package alfresco;

public class FizzBuzz {
    public String generate(int number) {
        if (number == 3) {
            return "fizz";
        }

        return String.valueOf(number);
    }
}
