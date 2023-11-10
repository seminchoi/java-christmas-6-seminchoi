package christmas.message;

public enum ErrorMessage {
    PREFIX("[ERROR] %s"),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(PREFIX.message, this.message);
    }
}
