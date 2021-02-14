package alfresco;

public class LimitMinorThanOneEx extends RuntimeException {
    private static final String MESSAGE = "The limit argument must be a number " +
        "equal or greater than 1";

    public LimitMinorThanOneEx() {
        super(MESSAGE);
    }
}
