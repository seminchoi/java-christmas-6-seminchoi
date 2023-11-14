package christmas.model.event;

import christmas.model.planner.ClientOrders;
import christmas.model.planner.EventPlanner;
import christmas.model.menu.Menu;
import christmas.model.calendar.DecemberDate;

public abstract class AbstractTargetDiscountEvent implements Event {
    private final int countPerDiscountAmount;

    protected AbstractTargetDiscountEvent(final int countPerDiscountAmount) {
        this.countPerDiscountAmount = countPerDiscountAmount;
    }

    @Override
    public void apply(final EventPlanner eventPlanner) {
        DecemberDate visitPlanDate = eventPlanner.getVisitPlanDate();
        if(isEventActive(visitPlanDate)) {
            ClientOrders clientOrders = eventPlanner.getClientOrders();
            int discountAmount = calculateDiscountAmount(clientOrders);
            eventPlanner.addBenefit(getKind(), discountAmount);
        }
    }

    abstract boolean isEventActive(final DecemberDate visitPlanDate);

    private int calculateDiscountAmount(final ClientOrders orderMenu) {
        return sumTargetMenuCount(orderMenu) * countPerDiscountAmount;
    }

    private int sumTargetMenuCount(final ClientOrders orderMenu) {
        int targetMenusCount = 0;

        for (Menu menu : orderMenu.getOrders().keySet()) {
            if(isTarget(menu)) {
                targetMenusCount += orderMenu.getCountByMenu(menu);
            }
        }

        return targetMenusCount;
    }

    abstract boolean isTarget(final Menu menu);
}
