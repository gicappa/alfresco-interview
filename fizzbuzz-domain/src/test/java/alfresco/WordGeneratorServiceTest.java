package alfresco;


import alfresco.words.WordMapper;
import alfresco.words.Words;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Testing that the FizzBuzzGeneratorUseCase is properly
 * interacting with the FizzBuzzMapper.
 */
class WordGeneratorServiceTest {

    private WordGeneratorService wordGeneratorService;
    private WordMapper mockWordMapper;
    private ReportGeneratorService mockReportGeneratorService;

    @BeforeEach
    void beforeEach() {
        // fixtures
        mockWordMapper = mock(WordMapper.class);
        mockReportGeneratorService = mock(ReportGeneratorService.class);

        var appContext = mock(AppContext.class);
        when(appContext.getWordMapper()).thenReturn(mockWordMapper);
        when(appContext.getFizzBuzzReporter()).thenReturn(mockReportGeneratorService);
        when(mockWordMapper.map(anyInt())).thenReturn("a string");

        // SUT
        wordGeneratorService = new WordGeneratorService(mockWordMapper);
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for limit times")
    void it_calls_the_fizzbuzz_1_to_limit_times() {
        wordGeneratorService.generateWords(100);

        verify(mockWordMapper, times(100))
            .map(anyInt());
    }

    @Test
    @DisplayName("It returns a Words class")
    void it_generates_a_Words_object_containing_a_list_of_strings() {

        assertThat(wordGeneratorService.generateWords(5))
            .isInstanceOf(Words.class);
    }

    @Test
    @DisplayName("It returns a Words object containing a list of strings")
    void it_returns_a_list_of_strings() {

        assertThat(wordGeneratorService.generateWords(5)
            .getWords()).hasSize(5);
        assertThat(wordGeneratorService.generateWords(5)
            .getWords().get(0)).isInstanceOf(String.class);
    }

    @Test
    @DisplayName("It throws an exception for a limit minor than one")
    void it_throws_an_exception_for_a_number_minor_than_one() {

        assertThatThrownBy(() -> wordGeneratorService.generateWords(-1))
            .isInstanceOf(LimitMinorThanOneEx.class);
    }

    @AfterEach
    public void afterEach() {
        reset(mockWordMapper);
        reset(mockReportGeneratorService);
    }
}

