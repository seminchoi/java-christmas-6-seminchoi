package christmas.dto;

import static christmas.message.OutputMessage.AMOUNT_FORMAT;
import static christmas.message.TitleMessage.BENEFIT_AMOUNT_TITLE;

public record BenefitsAmountDto(int benefitsAmount) {
    @Override
    public String toString() {
        final String title = BENEFIT_AMOUNT_TITLE.getMessage();
        final String content = String.format(AMOUNT_FORMAT.getMessage(), benefitsAmount);
        return title + content;
    }
}
