package alfresco.words;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Collecting the resulting Words object out of a stream.
 */
public class WordsCollector implements Collector<String, Words, Words> {

    public static WordsCollector toWords() {
        return new WordsCollector();
    }

    @Override
    public Supplier<Words> supplier() {
        return Words::new;
    }

    @Override
    public BiConsumer<Words, String> accumulator() {
        return Words::add;
    }

    @Override
    public BinaryOperator<Words> combiner() {
        return Words::addAll;
    }

    @Override
    public Function<Words, Words> finisher() {
        return words -> words;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}