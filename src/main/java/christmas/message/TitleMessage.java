package christmas.message;

public enum TitleMessage {
    TITLE_FORMAT("<%s>\n"),

    CLIENT_ORDER_MENU_TITLE("주문 메뉴"),
    ORDERS_AMOUNT_TITLE("할인 전 총주문 금액"),
    GIFT_ORDERS_TITLE("증정 메뉴"),
    BENEFITS_TITLE("혜택 내역"),
    BENEFIT_AMOUNT_TITLE("총혜택 금액"),
    PAYMENT_AMOUNT_TITLE("할인 후 예상 결제 금액"),
    ;

    private final String message;

    TitleMessage(String message) {
        this.message = message;
    }

    public static String getTitleFormat() {
        return TITLE_FORMAT.message;
    }

    public String getMessage() {
        return String.format(TITLE_FORMAT.message, this.message);
    }
}
