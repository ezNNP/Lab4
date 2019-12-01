package exceptions;

public class NotEnoughAmmoException extends RuntimeException {
    private String message;

    public NotEnoughAmmoException() {
    }

    public NotEnoughAmmoException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
