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
    private final FizzBuzzMapper fizzBuzzMapper;
    private final FizzBuzzGeneratorUseCase generator;
    private final FizzBuzzReporterUseCase reporter;

    /**
     * Creates the specific instances of the objects needed
     * by the application
     */
    DefaultAppContext() {
        rules = List.of(new DivisorRule(3, "fizz"),
                new DivisorRule(5, "buzz"),
                new ContainsDigitRule(3, "alfresco"),
                new BaseRule());

        fizzBuzzMapper = new FizzBuzzMapper(rules);
        generator = new FizzBuzzGeneratorUseCase(fizzBuzzMapper);
        reporter = new FizzBuzzReporterUseCase();
    }

    @Override
    public FizzBuzzMapper getFizzBuzzMapper() {
        return fizzBuzzMapper;
    }

    @Override
    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public FizzBuzzGeneratorUseCase getFizzBuzzGenerator() {
        return generator;
    }

    @Override
    public FizzBuzzReporterUseCase getFizzBuzzReporter() {
        return reporter;
    }
}

