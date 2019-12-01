package exceptions;

public class NotAbleToRobTheBankException extends Exception {
    private String message;

    public NotAbleToRobTheBankException() {
    }

    public NotAbleToRobTheBankException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
