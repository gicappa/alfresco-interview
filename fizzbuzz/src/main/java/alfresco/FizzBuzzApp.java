package alfresco;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class FizzBuzzApp {
    private final FizzBuzz fizzBuzz;

    public static void main(String[] args) {
        var app = new FizzBuzzApp(new FizzBuzz());
        app.generate(Integer.valueOf(args[0]));
    }

    public FizzBuzzApp(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public void generate(Integer rangeEnd) {
        System.out.println(
                IntStream.rangeClosed(1, rangeEnd)
                        .mapToObj(fizzBuzz::generate)
                        .collect(joining(" ")));
    }
}
