package christmas.model.event;

import static christmas.model.calendar.Day.SUNDAY;
import static christmas.model.event.EventType.SPECIAL_DISCOUNT;

import christmas.model.ClientOrders;
import christmas.model.calendar.DecemberDate;

public class SpecialDiscountEvent implements DiscountEvent {
    private final static EventType type = SPECIAL_DISCOUNT;
    private final static int DISCOUNT_AMOUNT = 1000;

    @Override
    public void apply(final DiscountResult result, final DecemberDate decemberDate, final ClientOrders orderMenu) {
        if(isEventActive(decemberDate)) {
            int discountAmount = calculateDiscountAmount();
            result.addResult(getType(), discountAmount);
        }
    }

    private int calculateDiscountAmount() {
        return DISCOUNT_AMOUNT;
    }

    private boolean isEventActive(DecemberDate decemberDate) {
        return decemberDate.getDay() == SUNDAY || decemberDate.isChristmas();
    }

    @Override
    public EventType getType() {
        return type;
    }
}
