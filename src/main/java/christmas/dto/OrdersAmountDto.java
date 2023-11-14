package christmas.dto;

import static christmas.message.OutputMessage.AMOUNT_FORMAT;
import static christmas.message.TitleMessage.AMOUNT_BEFORE_DISCOUNT_TITLE;

public record OrdersAmountDto(int ordersAmount) {
    @Override
    public String toString() {
        String title = AMOUNT_BEFORE_DISCOUNT_TITLE.getMessage();
        String content = String.format(AMOUNT_FORMAT.getMessage(), ordersAmount);
        return title + content;
    }
}
