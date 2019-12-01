package exceptions;

public class NotEnoughMoneyException extends Exception {
    private String message;

    public NotEnoughMoneyException(String message) {
        super(message);
        this.message = message;
    }

    public NotEnoughMoneyException() {
    }

    @Override
    public String getMessage() {
        return message;
    }
}
