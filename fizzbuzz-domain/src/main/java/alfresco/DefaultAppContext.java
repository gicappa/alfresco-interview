package alfresco;

import alfresco.rules.ContainsDigitRule;
import alfresco.rules.DivisorRule;
import alfresco.rules.BaseRule;

import java.util.List;

/**
 * Default implementation of the appContext that specifies
 * the rules to be applied.
 */
class DefaultAppContext implements AppContext {

    private final List<Rule> rules;
    private final WordMapper fizzBuzzMapper;
    private final WordGeneratorService generator;
    private final ReportGeneratorService reporter;

    /**
     * Creates the specific instances of the objects needed
     * by the application
     */
    DefaultAppContext() {
        rules = List.of(new DivisorRule(3, "fizz"),
                new DivisorRule(5, "buzz"),
                new ContainsDigitRule(3, "alfresco"),
                new BaseRule());

        fizzBuzzMapper = new WordMapper(rules);
        generator = new WordGeneratorService(fizzBuzzMapper);
        reporter = new ReportGeneratorService();
    }

    @Override
    public WordMapper getFizzBuzzMapper() {
        return fizzBuzzMapper;
    }

    @Override
    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public WordGeneratorService getFizzBuzzGenerator() {
        return generator;
    }

    @Override
    public ReportGeneratorService getFizzBuzzReporter() {
        return reporter;
    }
}

