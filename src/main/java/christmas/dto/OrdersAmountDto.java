package christmas.dto;

import static christmas.message.OutputMessage.AMOUNT_FORMAT;
import static christmas.message.TitleMessage.ORDERS_AMOUNT_TITLE;

public record OrdersAmountDto(int ordersAmount) {
    @Override
    public String toString() {
        final String title = ORDERS_AMOUNT_TITLE.getMessage();
        final String content = String.format(AMOUNT_FORMAT.getMessage(), ordersAmount);
        return title + content;
    }
}
