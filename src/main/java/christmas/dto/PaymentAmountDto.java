package christmas.dto;

import static christmas.message.OutputMessage.AMOUNT_FORMAT;
import static christmas.message.TitleMessage.PAYMENT_AMOUNT_TITLE;

public record PaymentAmountDto(int paymentAmount) {
    @Override
    public String toString() {
        final String title = PAYMENT_AMOUNT_TITLE.getMessage();
        final String content = String.format(AMOUNT_FORMAT.getMessage(), paymentAmount);
        return title + content;
    }
}
