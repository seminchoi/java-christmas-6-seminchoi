package christmas.model.event;

import static christmas.model.calendar.Day.SUNDAY;
import static christmas.model.event.EventKind.SPECIAL_DISCOUNT;

import christmas.model.EventPlanner;
import christmas.model.calendar.DecemberDate;

public class SpecialDiscountEvent implements Event {
    private final static EventKind kind = SPECIAL_DISCOUNT;
    private final static int DISCOUNT_AMOUNT = 1000;

    @Override
    public void apply(final EventPlanner eventPlanner) {
        DecemberDate plannedVisitDate = eventPlanner.getPlannedVisitDate();
        if(isEventActive(plannedVisitDate)) {
            int discountAmount = calculateDiscountAmount();

            DiscountResult result = eventPlanner.getDiscountResult();
            result.addResult(getKind(), discountAmount);
        }
    }

    private int calculateDiscountAmount() {
        return DISCOUNT_AMOUNT;
    }

    private boolean isEventActive(DecemberDate plannedVisitDate) {
        return plannedVisitDate.getDay() == SUNDAY || plannedVisitDate.isChristmas();
    }

    @Override
    public EventKind getKind() {
        return kind;
    }
}
