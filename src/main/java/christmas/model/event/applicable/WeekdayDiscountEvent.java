package christmas.model.event.applicable;

import static christmas.model.menu.MenuCategory.DESSERT;
import static christmas.model.event.EventKind.WEEKDAY_DISCOUNT;

import christmas.model.event.EventKind;
import christmas.model.menu.Menu;
import christmas.model.menu.MenuCategory;
import christmas.model.calendar.DecemberDate;

public class WeekdayDiscountEvent extends AbstractTargetDiscountEvent {
    private final static EventKind kind = WEEKDAY_DISCOUNT;
    private final static MenuCategory TARGET_CATEGORY = DESSERT;
    private final static int COUNT_PER_DISCOUNT_AMOUNT = -2_023;

    public WeekdayDiscountEvent() {
        super(COUNT_PER_DISCOUNT_AMOUNT);
    }

    @Override
    boolean isEventActive(final DecemberDate visitPlanDate) {
        return visitPlanDate.isWeekday();
    }

    @Override
    boolean isTarget(final Menu menu) {
        return menu.getCategory() == TARGET_CATEGORY;
    }

    @Override
    public EventKind getKind() {
        return kind;
    }
}
