package alfresco;

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

    public Words() {
        this(new ArrayList<>());
    }

    public Words(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }

    public void add(String string) {
        words.add(string);
    }

    public Words addAll(Words words) {
        this.words.addAll(words.getWords());
        return this;
    }

    public static Words of(String... array) {
        return new Words(Arrays.stream(array).collect(toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Words words1 = (Words) o;
        return Objects.equals(words, words1.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }
}
