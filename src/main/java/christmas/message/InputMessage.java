package christmas.message;

public enum InputMessage {
    VISIT_PLAN_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDERS("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
    ;

    private final String message;

    InputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
