package alfresco;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * The fizz buzz app prints out a series of numbers
 */
public class App {
    private final FizzBuzz fizzBuzz;

    public static void main(String[] args) {
        var app = new App(new FizzBuzz());
        app.generate(Integer.valueOf(args[0]));
    }

    public App(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public void generate(Integer rangeEnd) {
        System.out.println(
                IntStream.rangeClosed(1, rangeEnd)
                        .mapToObj(fizzBuzz::generate)
                        .collect(joining(" ")));
    }
}
