package domain.com.accountservice.exceptions;

/**
 * @Author Илья
 * @Created 08.07.2015.
 */
public class UserWithoutAccountException extends Exception {

    public UserWithoutAccountException() {
        super();
    }

    public UserWithoutAccountException(String message) {
        super(message);
    }

    public UserWithoutAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserWithoutAccountException(Throwable cause) {
        super(cause);
    }
}