package alfresco;

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
 * Testing that the application is calling the FizzBuzz generate method
 */
class FizzBuzzMainTest {

    private FizzBuzzGeneratorUseCase mockGenerator;
    private FizzBuzzReporterUseCase mockReporter;
    private SystemCommand command;

    @BeforeEach
    void beforeEach() {
        mockGenerator = mock(FizzBuzzGeneratorUseCase.class);
        mockReporter = mock(FizzBuzzReporterUseCase.class);
        command = new SystemCommand();
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
    @DisplayName("it calls the fizzbuzz generation for rangeEnd times")
    void it_calls_the_fizzbuzz_object_that_generates_a_report() {
        when(mockGenerator.generateWords(anyInt())).thenReturn(List.of("1", "2"));

        var fizzBuzzMain = new FizzBuzzMain(mockContext(mockGenerator, mockReporter));

        fizzBuzzMain.run("2");

        verify(mockReporter).report(List.of("1", "2"));
    }

    @Test
    @DisplayName("it creates the string report")
    void it_prints_the_report() {
        var fizzBuzzMain = new FizzBuzzMain();

        var report = fizzBuzzMain.computeReport(Map.of("alfresco", 10L));

        assertThat(report).contains("alfresco: 10");
    }

    AppContext mockContext(FizzBuzzGeneratorUseCase generator, FizzBuzzReporterUseCase reporter) {
        AppContext context = mock(AppContext.class);
        when(context.getFizzBuzzGenerator()).thenReturn(generator);
        when(context.getFizzBuzzReporter()).thenReturn(reporter);
        return context;
    }

}
