package christmas.model;

import christmas.model.calendar.DecemberDate;
import christmas.model.event.DiscountResult;

public class EventPlanner {
    private final DecemberDate plannedVisitDate;
    private final ClientOrders clientOrders;

    private GiftOrders giftOrders;
    private DiscountResult discountResult;
    private Badges badges;

    public EventPlanner(DecemberDate plannedVisitDate, ClientOrders clientOrders) {
        this.plannedVisitDate = plannedVisitDate;
        this.clientOrders = clientOrders;
    }
}
