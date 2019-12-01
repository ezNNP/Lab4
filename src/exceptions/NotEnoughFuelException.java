package exceptions;

public class NotEnoughFuelException extends RuntimeException {
    private String message;

    public NotEnoughFuelException(String message) {
        super(message);
        this.message = message;
    }

    public NotEnoughFuelException() {
    }

    @Override
    public String getMessage() {
        return message;
    }
}
