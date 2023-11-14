package christmas.util;

import christmas.model.calendar.DecemberDate;
import christmas.model.order.ClientOrders;
import christmas.model.planner.EventPlanner;

import java.util.HashMap;
import java.util.Map;

public class EventUtil {
    public static EventPlanner createEventPlannerByDate(final int date, final Map<String, Integer> orders) {
        final DecemberDate visitPlanDate = new DecemberDate(date);
        final ClientOrders clientOrders = new ClientOrders(orders);

        return new EventPlanner(visitPlanDate, clientOrders);
    }
}
