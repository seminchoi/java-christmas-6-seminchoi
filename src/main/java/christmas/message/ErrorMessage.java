package christmas.message;

public enum ErrorMessage {
    PREFIX("[ERROR] %s"),
    OUT_OF_RANGE_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    TOO_MANY_ORDERS("최대 주문 개수를 초과하였습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(PREFIX.message, this.message);
    }
}
