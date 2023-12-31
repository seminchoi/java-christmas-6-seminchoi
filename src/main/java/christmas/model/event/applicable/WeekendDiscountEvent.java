package christmas.model.event.applicable;

import static christmas.model.menu.MenuCategory.MAIN;
import static christmas.model.event.EventKind.WEEKEND_DISCOUNT;

import christmas.model.event.EventKind;
import christmas.model.menu.Menu;
import christmas.model.menu.MenuCategory;
import christmas.model.calendar.DecemberDate;

public class WeekendDiscountEvent extends AbstractTargetDiscountEvent {
    private final static EventKind kind = WEEKEND_DISCOUNT;
    private final static MenuCategory TARGET_CATEGORY = MAIN;
    private final static int COUNT_PER_DISCOUNT_AMOUNT = -2_023;

    public WeekendDiscountEvent() {
        super(COUNT_PER_DISCOUNT_AMOUNT);
    }

    boolean isEventActive(final DecemberDate visitPlanDate) {
        return !visitPlanDate.isWeekday();
    }
    boolean isTarget(final Menu menu) {
        return menu.getCategory() == TARGET_CATEGORY;
    }

    @Override
    public EventKind getKind() {
        return kind;
    }
}
