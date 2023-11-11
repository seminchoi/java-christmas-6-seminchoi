package christmas.model.event;

import static christmas.model.event.EventType.CHRISTMAS_DISCOUNT;

import christmas.model.ClientOrders;
import christmas.model.calendar.DecemberDate;

public class ChristmasDiscountEvent implements DiscountEvent {
    private final static EventType type = CHRISTMAS_DISCOUNT;
    private final static int BASIC_DISCOUNT_AMOUNT = 1000;
    private final static int ADDITIONAL_DISCOUNT_AMOUNT_PER_DATE = 100;

    @Override
    public void apply(final DiscountResult result, final DecemberDate decemberDate, final ClientOrders orderMenu) {
        if (isEventActive(decemberDate)) {
            int discountAmount = calculateDiscountAmount(decemberDate.getDate());
            result.addResult(getType(), discountAmount);
        }
    }

    private int calculateDiscountAmount(final int date) {
        return BASIC_DISCOUNT_AMOUNT + ((date - 1) * ADDITIONAL_DISCOUNT_AMOUNT_PER_DATE);
    }

    private boolean isEventActive(final DecemberDate decemberDate) {
        return decemberDate.isNotOverChristmas();
    }

    @Override
    public EventType getType() {
        return type;
    }
}