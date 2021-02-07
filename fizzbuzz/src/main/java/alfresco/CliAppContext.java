package alfresco;

import alfresco.rules.ContainsDigitRule;
import alfresco.rules.DivisorRule;
import alfresco.rules.ToStringRule;

import java.util.List;

class CliAppContext implements AppContext {
    private final List<Rule> rules;
    private final FizzBuzzIt fizzBuzzIt;

    public CliAppContext() {
        rules = List.of(new DivisorRule(3, "fizz"),
                new DivisorRule(5, "buzz"),
                new ContainsDigitRule(3, "alfresco"),
                new ToStringRule());

        fizzBuzzIt = new FizzBuzzIt(rules);
    }

    public FizzBuzzIt getFizzBuzzIt() {
        return fizzBuzzIt;
    }

    public List<Rule> getRules() {
        return rules;
    }
}

