package alfresco.words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * Model Class containing and carrying the fizzbuzz words.
 */
public class Words {

    private final List<String> words;

    /**
     * Default constructor of a Words instance
     * with an empty list of values
     */
    public Words() {
        this(new ArrayList<>());
    }

    /**
     * Constructor to build a Words instance with
     * a list of values passed to the constructor
     *
     * @param words the list of values to build the object
     */
    public Words(List<String> words) {
        this.words = words;
    }

    /**
     * Helper to create a words
     *
     * @param array vararg to create a Words object
     * @return an instance of the class Words
     */
    public static Words of(String... array) {
        return new Words(Arrays.stream(array).collect(toList()));
    }

    /**
     * @return the list of values to be added
     */
    public List<String> getWords() {
        return words;
    }

    /**
     * Add a word value to the Words object instance
     *
     * @param value the value to be added
     */
    public void add(String value) {
        words.add(value);
    }

    /**
     * Adds the list of the generated words to the one in
     * input
     *
     * @param words the external object that contains the
     *              words to be added
     * @return this instance with the word of the other
     * object added
     */
    public Words addAll(Words words) {
        this.words.addAll(words.getWords());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Words words1 = (Words) o;
        return Objects.equals(words, words1.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }
}
