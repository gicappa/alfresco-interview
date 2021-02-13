package alfresco;

import alfresco.words.Words;

import java.util.List;

public class WordsResponse {
    
    public final List<String> words;
    private final int limit;

    public WordsResponse(Words words, int limit) {
        this.words = words.getWords();
        this.limit = limit;
    }

    public List<String> getWords() {
        return words;
    }

    public int getLimit() {
        return limit;
    }
}
