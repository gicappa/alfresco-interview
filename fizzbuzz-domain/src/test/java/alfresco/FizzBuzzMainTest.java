package alfresco;

import alfresco.words.Words;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Testing that the entry point of the application is handling
 * the command line parameters.
 */
class FizzBuzzMainTest {

    private WordGeneratorService mockGenerator;
    private ReportGeneratorService mockReporter;
    private SystemCommand command;
    private FizzBuzzMain fizzBuzzMain;

    @BeforeEach
    void beforeEach() {
        mockGenerator = mock(WordGeneratorService.class);
        mockReporter = mock(ReportGeneratorService.class);
        command = new SystemCommand();
        fizzBuzzMain = new FizzBuzzMain();
    }

    @ParameterizedTest
    @CsvSource({
            "java -cp target/classes alfresco.FizzBuzzMain,       128",
            "java -cp target/classes alfresco.FizzBuzzMain 1 2 3, 128",
            "java -cp target/classes alfresco.FizzBuzzMain blah,  1"
    })
    @DisplayName("it displays usage when no number or while are passed")
    void it_prints_the_usage_when_no_args_are_passed(String cmdString, int exitValue) {
        var result =
                command.run(cmdString);

        assertThat(result.getExitValue()).isEqualTo(exitValue);
        assertThat(result.getStderr()).contains("usage");
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for 1 to limit times")
    void it_calls_the_fizzbuzz_object_that_generates_a_report() {
        when(mockGenerator.generateWords(anyInt())).thenReturn(new Words(List.of("1", "2")));

        var fizzBuzzMain = new FizzBuzzMain(mockContext(mockGenerator, mockReporter));

        fizzBuzzMain.run("2");

        verify(mockReporter).generateReport(Words.of("1", "2"));
    }

    @Test
    @DisplayName("it creates the string report")
    void it_prints_the_report_for_alfresco() {
        var report = fizzBuzzMain.formatListReport(Map.of("alfresco", 10L));

        assertThat(report).containsExactly("alfresco: 10");
    }

    @Test
    @DisplayName("it creates the string report")
    void it_prints_the_report_alfresco_fizz() {

        var alfresco = Map.of(
                "alfresco", 10L,
                "buzz", 20L,
                "fizz", 30L,
                "integer", 40L,
                "fizzbuzz", 50L
        );

        var report = fizzBuzzMain.formatListReport(alfresco);

        assertThat(report).containsExactly(
                "fizz: 30", "buzz: 20", "fizzbuzz: 50", "alfresco: 10", "integer: 40");
    }

    AppContext mockContext(WordGeneratorService generator, ReportGeneratorService reporter) {
        AppContext context = mock(AppContext.class);
        when(context.getFizzBuzzGenerator()).thenReturn(generator);
        when(context.getFizzBuzzReporter()).thenReturn(reporter);
        return context;
    }

}
