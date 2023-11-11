package christmas.model.event;

import christmas.model.ClientOrders;
import christmas.model.Menu;
import christmas.model.calendar.DecemberDate;

public abstract class AbstractTargetDiscountEvent<T> implements DiscountEvent {
    private final int countPerDiscountAmount;
    protected final T discountTarget;

    protected AbstractTargetDiscountEvent(final int countPerDiscountAmount, final T discountTarget) {
        this.countPerDiscountAmount = countPerDiscountAmount;
        this.discountTarget = discountTarget;
    }

    @Override
    public int apply(final DecemberDate decemberDate, final ClientOrders orderMenu) {
        if(isEventActive(decemberDate)) {
            return calculateDiscountAmount(orderMenu);
        }
        return 0;
    }

    abstract boolean isEventActive(final DecemberDate decemberDate);

    private int calculateDiscountAmount(final ClientOrders orderMenu) {
        return sumTargetMenuCount(orderMenu) * countPerDiscountAmount;
    }

    private int sumTargetMenuCount(final ClientOrders orderMenu) {
        int targetMenusCount = 0;

        for (Menu menu : orderMenu) {
            if(isTarget(menu)) {
                targetMenusCount += orderMenu.getCountByMenu(menu);
            }
        }

        return targetMenusCount;
    }

    abstract boolean isTarget(final Menu menu);
}
