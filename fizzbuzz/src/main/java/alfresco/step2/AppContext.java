package alfresco.step2;

import alfresco.step2.rules.ContainsDigitRule;
import alfresco.step2.rules.DivisorRule;
import alfresco.step2.rules.ToStringRule;

import java.util.List;

public class AppContext {

    private final List<Rule> rules;
    private final FizzBuzzIt fizzBuzzIt;

    public AppContext() {
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
