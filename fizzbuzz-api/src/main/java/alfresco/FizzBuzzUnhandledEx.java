package alfresco;

public class FizzBuzzUnhandledEx extends RuntimeException {
    public FizzBuzzUnhandledEx() {
        super("The FizzBuzz application had an internal unexpected error. Please contact the FizzBuzz LTD to further investigate what happened.");
    }
}
