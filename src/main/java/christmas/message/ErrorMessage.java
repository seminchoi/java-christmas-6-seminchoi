package christmas.message;

public enum ErrorMessage {
    PREFIX("[ERROR] %s"),
    OUT_OF_RANGE_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요.")
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(PREFIX.message, this.message);
    }
}
