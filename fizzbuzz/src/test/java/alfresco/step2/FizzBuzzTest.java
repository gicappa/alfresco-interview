package alfresco.step2;

import alfresco.step1.FizzBuzz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void before() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Given a number in input it returns the same number as a string")
    void it_prints_a_number() {
        assertThat(fizzBuzz.generate(1)).isEqualTo("1");
    }

    @Test
    @DisplayName("Given 3 in input it returns the string 'fizz'")
    void it_prints_fizz_when_the_number_is_three() {
        assertThat(fizzBuzz.generate(3)).isEqualTo("fizz");
    }

    @Test
    @DisplayName("Given 5 in input it returns the string 'buzz'")
    void it_prints_buzz_when_the_number_is_five() {
        assertThat(fizzBuzz.generate(5)).isEqualTo("buzz");
    }

    @Test
    @DisplayName("Given a multiple of 3 in input it returns the string 'fizz'")
    void it_prints_fizz_when_the_number_is_a_multiple_of_three() {
        assertThat(fizzBuzz.generate(27)).isEqualTo("fizz");
    }

    @Test
    @DisplayName("Given 5 in input it returns the string 'buzz'")
    void it_prints_buzz_when_the_number_is_a_multiple_of_five() {
        assertThat(fizzBuzz.generate(25)).isEqualTo("buzz");
    }

    @Test
    @DisplayName("Given 15 in input it returns the string 'fizzbuzz'")
    void it_prints_buzz_when_the_number_is_a_multiple_of_fifteen() {
        assertThat(fizzBuzz.generate(30)).isEqualTo("fizzbuzz");
    }

}
