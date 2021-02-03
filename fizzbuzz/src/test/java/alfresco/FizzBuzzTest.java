package alfresco;

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
    @DisplayName("Given 3 in input generates a the string 'fizz'")
    void it_prints_fizz_when_the_number_is_three() {
        assertThat(fizzBuzz.generate(3)).isEqualTo("fizz");
    }
}
