package christmas.model.event;

import static christmas.model.event.EventKind.CHRISTMAS_DISCOUNT;

import christmas.model.EventPlanner;
import christmas.model.calendar.DecemberDate;

public class ChristmasDiscountEvent implements Event {
    private final static EventKind kind = CHRISTMAS_DISCOUNT;
    private final static int BASIC_DISCOUNT_AMOUNT = 1000;
    private final static int ADDITIONAL_DISCOUNT_AMOUNT_PER_DATE = 100;

    @Override
    public void apply(final EventPlanner eventPlanner) {
        DecemberDate visitPlanDate = eventPlanner.getVisitPlanDate();
        if (isEventActive(visitPlanDate)) {
            int discountAmount = calculateDiscountAmount(visitPlanDate.getDate());
            eventPlanner.addDiscountResult(getKind(), discountAmount);
        }
    }

    private boolean isEventActive(final DecemberDate visitPlanDate) {
        return visitPlanDate.isNotOverChristmas();
    }

    private int calculateDiscountAmount(final int date) {
        return BASIC_DISCOUNT_AMOUNT + ((date - 1) * ADDITIONAL_DISCOUNT_AMOUNT_PER_DATE);
    }

    @Override
    public EventKind getKind() {
        return kind;
    }
}