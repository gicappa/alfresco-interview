package alfresco;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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
        mockWordMapper = mock(WordMapper.class);
        mockReportGeneratorService = mock(ReportGeneratorService.class);

        var appContext = mock(AppContext.class);
        when(appContext.getFizzBuzzMapper()).thenReturn(mockWordMapper);
        when(appContext.getFizzBuzzReporter()).thenReturn(mockReportGeneratorService);

        // SUT
        wordGeneratorService = new WordGeneratorService(mockWordMapper);
    }

    @Test
    @DisplayName("it calls the fizzbuzz generation for rangeEnd times")
    void it_calls_the_fizzbuzz_rangeEnd_times() {
        wordGeneratorService.generateWords(20);

        verify(mockWordMapper, times(20))
                .map(anyInt());
    }

    @Test
    @DisplayName("It returns a Words containing Word")
    void it_generates_a_Words_object_containing_a_list_of_Word() {
        assertThat(wordGeneratorService.generateWords(5))
            .isInstanceOf(Words.class);
    }

    @Test
    @DisplayName("It returns a Words object containing Word objects")
    void it_invokes_a_list_of_words() {
        assertThat(wordGeneratorService.generateWords(5)
            .getWords()).hasSize(5);
    }

    @AfterEach
    public void afterEach() {
        reset(mockWordMapper);
        reset(mockReportGeneratorService);

    }
}

