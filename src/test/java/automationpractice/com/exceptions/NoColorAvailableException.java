package automationpractice.com.exceptions;

public class NoColorAvailableException extends RuntimeException {
    public NoColorAvailableException(final String message) {
        super(message);
    }
}
