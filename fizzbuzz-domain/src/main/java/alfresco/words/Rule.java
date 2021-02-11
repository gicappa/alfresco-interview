package alfresco.words;

/**
 * Rule is the abstraction of all the rules that can
 * be applied to the base number translation for the
 * fizz buzz
 */
public interface Rule {
    String apply(int number, String result);
}
