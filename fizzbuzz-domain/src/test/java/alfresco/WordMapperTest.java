package alfresco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordMapperTest {

    private WordMapper fizzBuzz;

    @BeforeEach
    void before() {
        fizzBuzz = new WordMapper(new DefaultAppContext().getRules());
    }

    @Test
    @DisplayName("Given a number in input it returns the same number as a string")
    void it_prints_a_number() {
        assertThat(fizzBuzz.map(1)).isEqualTo("1");
    }

    @Test
    @DisplayName("Given 3 in input it returns the string 'alfresco'")
    void it_prints_alfresco_when_the_number_is_three() {
        assertThat(fizzBuzz.map(3)).isEqualTo("alfresco");
    }

    @Test
    @DisplayName("Given 5 in input it returns the string 'buzz'")
    void it_prints_buzz_when_the_number_is_five() {
        assertThat(fizzBuzz.map(5)).isEqualTo("buzz");
    }

    @Test
    @DisplayName("Given a multiple of 3 in input it returns the string 'fizz'")
    void it_prints_fizz_when_the_number_is_a_multiple_of_three() {
        assertThat(fizzBuzz.map(27)).isEqualTo("fizz");
    }

    @Test
    @DisplayName("Given a multiple of 5 in input it returns the string 'buzz'")
    void it_prints_buzz_when_the_number_is_a_multiple_of_five() {
        assertThat(fizzBuzz.map(25)).isEqualTo("buzz");
    }

    @Test
    @DisplayName("Given a number containing a 3 in input it returns the string 'alfresco'")
    void it_prints_alfresco_when_the_number_contains_a_three() {
        assertThat(fizzBuzz.map(30)).isEqualTo("alfresco");
    }

    @Test
    @DisplayName("Given 45 in input it returns the string 'fizzbuzz'")
    void it_prints_fizzbuzz_when_the_number_is_a_multiple_of_fifteen() {
        assertThat(fizzBuzz.map(45)).isEqualTo("fizzbuzz");
    }

}
