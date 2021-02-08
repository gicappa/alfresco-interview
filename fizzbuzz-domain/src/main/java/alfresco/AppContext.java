package alfresco;

import java.util.List;

/**
 * AppContext allow create and wire all the object contained
 * in the application, ready to be used by the application
 * itself. It is a way to separate the building of the objects
 * and their usage.
 */
public interface AppContext {

    /**
     * @return the object able to translate a number in a word
     */
    FizzBuzzMapper getFizzBuzzMapper();

    /**
     * @return the list of rule applicable to the numbers to generate
     * a word. It is a list since it is needed to keep their order
     */
    List<Rule> getRules();

    /**
     * @return the object able to count the occurrence of a certain
     * word type
     */
    FizzBuzzGeneratorUseCase getFizzBuzzGenerator();
    /**
     * @return the object able to count the occurrence of a certain
     * word type
     */
    FizzBuzzReporterUseCase getFizzBuzzReporter();
}
