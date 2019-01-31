package automationpractice.com.exceptions;

public class NoProductsOnHomePageException extends RuntimeException {
    public NoProductsOnHomePageException(final String message) {
        super(message);
    }
}
