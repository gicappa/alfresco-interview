package alfresco;

import alfresco.rules.ContainsDigitRule;
import alfresco.rules.DivisorRule;
import alfresco.rules.ToStringRule;

import java.util.List;

class CliAppContext implements AppContext {
    private final List<Rule> rules;
    private final FizzBuzzMapper fizzBuzzMapper;

    public CliAppContext() {
        rules = List.of(new DivisorRule(3, "fizz"),
                new DivisorRule(5, "buzz"),
                new ContainsDigitRule(3, "alfresco"),
                new ToStringRule());

        fizzBuzzMapper = new FizzBuzzMapper(rules);
    }

    public FizzBuzzMapper getFizzBuzzMapper() {
        return fizzBuzzMapper;
    }

    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public FizzBuzzReporter getFizzBuzzReporter() {
        return new FizzBuzzReporter();
    }
}

