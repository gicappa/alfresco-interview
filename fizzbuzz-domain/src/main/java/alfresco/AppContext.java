package alfresco;

import alfresco.words.Rule;
import alfresco.words.WordMapper;

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
    WordMapper getWordMapper();

    /**
     * @return the list of rule applicable to the numbers to generate
     * a word. It is a list since it is needed to keep their order
     */
    List<Rule> getRules();

    /**
     * @return the object able to count the occurrence of a certain
     * word type
     */
    WordGeneratorService getFizzBuzzGenerator();
    /**
     * @return the object able to count the occurrence of a certain
     * word type
     */
    ReportGeneratorService getFizzBuzzReporter();
}
