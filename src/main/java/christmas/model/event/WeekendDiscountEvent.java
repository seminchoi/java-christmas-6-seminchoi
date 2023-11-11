package christmas.model.event;

import christmas.model.Menu;
import christmas.model.MenuCategory;
import christmas.model.calendar.DecemberDate;

import static christmas.model.MenuCategory.MAIN;
import static christmas.model.event.EventType.WEEKEND_DISCOUNT;

public class WeekendDiscountEvent extends AbstractTargetDiscountEvent {
    private final static EventType type = WEEKEND_DISCOUNT;
    private final static MenuCategory TARGET_CATEGORY = MAIN;
    private final static int COUNT_PER_DISCOUNT_AMOUNT = 2023;

    protected WeekendDiscountEvent() {
        super(COUNT_PER_DISCOUNT_AMOUNT);
    }

    boolean isEventActive(final DecemberDate decemberDate) {
        return !decemberDate.isWeekDay();
    }
    boolean isTarget(final Menu menu) {
        return menu.getCategory() == TARGET_CATEGORY;
    }

    @Override
    public EventType getType() {
        return type;
    }
}
