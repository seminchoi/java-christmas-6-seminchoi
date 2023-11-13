package christmas.message;

public enum MessageFormat {
    WON("원"),

    INTRODUCTION_FORMAT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    AMOUNT_FORMAT("%,d" + WON.message),
    ORDER_FORMAT("%s %d개"),
    BENEFIT_FORMAT("%s: " + AMOUNT_FORMAT.message),
    ;

    private final String message;

    MessageFormat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
