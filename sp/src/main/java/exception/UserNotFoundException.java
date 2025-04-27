package exception;  // Correct package name

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);  // Passes the message to the RuntimeException constructor
    }
}
