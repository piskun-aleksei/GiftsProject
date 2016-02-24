package by.bsuir.gift.exception;

/**
 * Created by Алексей on 24.02.2016.
 */
public class InvalidNumberExceprion extends Exception {
    public InvalidNumberExceprion() {
    }

    public InvalidNumberExceprion(String message) {
        super(message);
    }

    public InvalidNumberExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberExceprion(Throwable cause) {
        super(cause);
    }

    public InvalidNumberExceprion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
