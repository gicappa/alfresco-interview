package alfresco;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FizzBuzzReporter {
    public Map<String, Long> report(List<String> words) {
        return words.stream()
                .map(this::toInteger)
                .collect(groupingBy(identity(), counting()));
    }

    public String toInteger(String word) {
        try {
            parseInt(word);
            return "integer";
        } catch (NumberFormatException nfe) {
            return word;
        }

    }
}
