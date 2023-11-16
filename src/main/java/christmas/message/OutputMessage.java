package christmas.message;

public enum OutputMessage {
    WON("원"),
    NOTHING("없음"),

    VISIT_PLAN_DATE_FORMAT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    AMOUNT_FORMAT("%,d" + WON.message),
    ORDER_FORMAT("%s %d개"),
    BENEFIT_FORMAT("%s: %,d" + WON.message),
    ;

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message + "\n";
    }
}
