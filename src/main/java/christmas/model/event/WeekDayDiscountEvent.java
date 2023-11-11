package christmas.model.event;

import static christmas.model.MenuCategory.DESSERT;
import static christmas.model.event.EventType.WEEK_DAY_DISCOUNT;

import christmas.model.Menu;
import christmas.model.MenuCategory;
import christmas.model.calendar.DecemberDate;

public class WeekDayDiscountEvent extends AbstractTargetDiscountEvent {
    private final static EventType type = WEEK_DAY_DISCOUNT;
    private final static MenuCategory TARGET_CATEGORY = DESSERT;
    private final static int COUNT_PER_DISCOUNT_AMOUNT = 2023;

    public WeekDayDiscountEvent() {
        super(COUNT_PER_DISCOUNT_AMOUNT);
    }

    @Override
    boolean isEventActive(DecemberDate decemberDate) {
        return decemberDate.isWeekDay();
    }

    @Override
    boolean isTarget(Menu menu) {
        return menu.getCategory() == TARGET_CATEGORY;
    }

    @Override
    public EventType getType() {
        return type;
    }
}
