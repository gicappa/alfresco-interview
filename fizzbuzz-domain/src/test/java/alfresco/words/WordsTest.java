package alfresco.words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordsTest {
    private Words wordsOne;
    private Words wordsTwo;
    private Words wordsThree;

    @BeforeEach
    void beforeEach() {
        wordsOne = Words.of("1", "2", "3");
        wordsTwo = Words.of("4", "5");
        wordsThree = Words.of("4", "5");
    }

    @Test
    @DisplayName("It adds all the words of another set of words")
    void it_adds_all_the_words_of_another_set_of_words() {
        var wordsResults = wordsOne.addAll(wordsTwo);

        assertThat(wordsOne.getWords()).containsExactly("1", "2", "3", "4", "5");
        assertThat(wordsResults.getWords()).containsExactly("1", "2", "3", "4", "5");
    }

    @Test
    @DisplayName("It compares with another word object")
    void it_compares_with_another_words_object() {

        assertThat(wordsTwo).isEqualTo(wordsThree);
        assertThat(wordsOne).isNotEqualTo(wordsThree);
    }
}
