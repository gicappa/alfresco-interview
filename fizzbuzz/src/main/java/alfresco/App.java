package alfresco;

import java.util.stream.IntStream;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class App {
    private final FizzBuzz fizzBuzz;

    public static void main(String[] args) {
        System.out.print(args[0]);
    }

    public App(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public void generate(Integer rangeEnd) {
        IntStream.rangeClosed(1, rangeEnd)
                .forEach(fizzBuzz::generate);
    }
}
