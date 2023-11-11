package christmas.model.event;

import static christmas.model.event.EventType.CHRISTMAS_DISCOUNT;

import christmas.model.ClientOrders;
import christmas.model.calendar.DecemberDate;

public class ChristmasDiscountEvent implements DiscountEvent {
    private final static EventType type = CHRISTMAS_DISCOUNT;
    private final static int END_DATE = 25;
    private final static int BASIC_DISCOUNT_AMOUNT = 1000;
    private final static int ADDITIONAL_DISCOUNT_AMOUNT_PER_DATE = 100;

    @Override
    public int apply(final DecemberDate decemberDate, final ClientOrders orderMenu) {
        int date = decemberDate.getDate();
        return calculateDiscountAmount(date);
    }

    private int calculateDiscountAmount(int date) {
        if(isOver(date)) {
            return 0;
        }
        return BASIC_DISCOUNT_AMOUNT + ((date - 1) * ADDITIONAL_DISCOUNT_AMOUNT_PER_DATE);
    }

    private boolean isOver(int date) {
        return date > END_DATE;
    }

    @Override
    public EventType getType() {
        return type;
    }
}