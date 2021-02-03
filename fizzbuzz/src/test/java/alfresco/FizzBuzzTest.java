package alfresco;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    @Test
    @DisplayName("Given a number in input generates a number in the output string")
    void it_prints_a_number() {
        var fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.generate(1)).isEqualTo("1");
    }
}
