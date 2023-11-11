package christmas.model.event;

import static christmas.model.MenuCategory.DESSERT;
import static christmas.model.event.EventType.WEEK_DAY_DISCOUNT;

import christmas.model.ClientOrders;
import christmas.model.Menu;
import christmas.model.calendar.DecemberDate;

public class WeekDayDiscountEvent implements DiscountEvent {
    private final static EventType type = WEEK_DAY_DISCOUNT;
    private final static int COUNT_PER_DISCOUNT_AMOUNT = 2023;

    @Override
    public int apply(final DecemberDate decemberDate, final ClientOrders orderMenu) {
        if(isEventActive(decemberDate)) {
            return calculateDiscountAmount(orderMenu);
        }
        return 0;
    }

    private boolean isEventActive(final DecemberDate decemberDate) {
        return decemberDate.isWeekDay();
    }

    private int calculateDiscountAmount(final ClientOrders orderMenu) {
        return sumTargetMenuCount(orderMenu) * COUNT_PER_DISCOUNT_AMOUNT;
    }

    private int sumTargetMenuCount(final ClientOrders orderMenu) {
        int targetMenusCount = 0;

        for (Menu menu : orderMenu) {
            if(isTargetMenu(menu)) {
                targetMenusCount += orderMenu.getCountByMenu(menu);
            }
        }

        return targetMenusCount;
    }

    private boolean isTargetMenu(Menu menu) {
        return menu.getCategory() == DESSERT;
    }

    @Override
    public EventType getType() {
        return type;
    }
}
