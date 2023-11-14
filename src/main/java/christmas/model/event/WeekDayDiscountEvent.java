package christmas.model.event;

import static christmas.model.menu.MenuCategory.DESSERT;
import static christmas.model.event.EventKind.WEEK_DAY_DISCOUNT;

import christmas.model.menu.Menu;
import christmas.model.menu.MenuCategory;
import christmas.model.calendar.DecemberDate;

public class WeekDayDiscountEvent extends AbstractTargetDiscountEvent {
    private final static EventKind kind = WEEK_DAY_DISCOUNT;
    private final static MenuCategory TARGET_CATEGORY = DESSERT;
    private final static int COUNT_PER_DISCOUNT_AMOUNT = -2_023;

    public WeekDayDiscountEvent() {
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
