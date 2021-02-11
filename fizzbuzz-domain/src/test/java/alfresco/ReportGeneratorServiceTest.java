package alfresco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReportGeneratorServiceTest {

    private ReportGeneratorService fizzBuzzReporter;

    @BeforeEach
    public void beforeEach() {
        fizzBuzzReporter = new ReportGeneratorService();
    }

    @Test
    @DisplayName("It returns a map with key 'integer' and value '2L'" +
            "when 2 integer are in the list")
    void it_returns_an_integer_with_a_counter() {
        var input = Words.of("1", "2");

        assertThat(fizzBuzzReporter.generateReport(input))
                .containsKey("integer")
                .containsValue(2L);
    }

    @Test
    @DisplayName("It returns a map with key 'alfresco' and value '3L'" +
            "when 3 string 'alfresco' are in the list")
    void it_counts_the_occurrence_of_a_given_string_in_a_list() {
        var input = Words.of("alfresco", "alfresco", "alfresco");

        assertThat(fizzBuzzReporter.generateReport(input))
                .containsKey("alfresco")
                .containsValue(3L);
    }

    @Test
    @DisplayName("It translate a number into the 'integer' string")
    void it_returns_integer_if_is_a_number() {
        assertThat(fizzBuzzReporter.toInteger("1")).isEqualTo("integer");
    }

    @Test
    @DisplayName("It translate a string into the same string")
    void it_returns_string_unmodified() {
        assertThat(fizzBuzzReporter.toInteger("foobar"))
                .isEqualTo("foobar");
    }
}