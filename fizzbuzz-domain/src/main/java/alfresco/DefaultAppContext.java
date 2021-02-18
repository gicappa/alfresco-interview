package alfresco;

import java.util.List;

import alfresco.words.Rule;
import alfresco.words.WordMapper;
import alfresco.words.rules.BaseRule;
import alfresco.words.rules.ContainsDigitRule;
import alfresco.words.rules.DivisorRule;

/**
 * Default implementation of the appContext that specifies
 * the rules to be applied.
 */
class DefaultAppContext implements AppContext {

    private final List<Rule> rules;

    private final WordMapper wordMapper;

    private final WordGeneratorService wordGenerator;
    private final ReportGeneratorService reportGenerator;

    /**
     * Creates the specific instances of the objects needed
     * by the application
     */
    DefaultAppContext() {
        rules = List.of(
            new DivisorRule(3, "fizz"),
            new DivisorRule(5, "buzz"),
            new ContainsDigitRule(3, "alfresco"),
            new BaseRule()
        );

        wordMapper = new WordMapper(rules);
        wordGenerator = new WordGeneratorService(wordMapper);
        reportGenerator = new ReportGeneratorService();
    }

    @Override
    public WordMapper getWordMapper() {
        return wordMapper;
    }

    @Override
    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public WordGeneratorService getFizzBuzzGenerator() {
        return wordGenerator;
    }

    @Override
    public ReportGeneratorService getFizzBuzzReporter() {
        return reportGenerator;
    }
}

