package christmas.util;

import christmas.model.calendar.DecemberDate;
import christmas.model.event.EventKind;
import christmas.model.event.applicable.Event;
import christmas.model.event.result.Benefits;
import christmas.model.menu.Menu;
import christmas.model.order.ClientOrders;
import christmas.model.order.GiftOrders;
import christmas.model.planner.EventPlanner;

import java.util.HashMap;
import java.util.Map;

public class EventUtil {
    public static Map<String, Integer> createTestOrders() {
        final Map<String, Integer> orders = new HashMap<>();
        orders.put("시저샐러드", 5);
        orders.put("해산물파스타", 5);
        orders.put("초코케이크", 5);
        orders.put("제로콜라", 5);

        return orders;
    }

    public static EventPlanner createEventPlannerByDate(final int date, final Map<String, Integer> orders) {
        final DecemberDate visitPlanDate = new DecemberDate(date);
        final ClientOrders clientOrders = new ClientOrders(orders);

        return new EventPlanner(visitPlanDate, clientOrders);
    }

    public static int applyAndGetDiscountAmount(final Event event, final EventPlanner eventPlanner) {
        Map<EventKind, Integer> benefitResult = applyAndGetBenefitResult(event, eventPlanner);
        return benefitResult.get(event.getKind());
    }

    public static Map<EventKind, Integer> applyAndGetBenefitResult(
            final Event event, final EventPlanner eventPlanner
    ) {
        event.apply(eventPlanner);
        Benefits benefits = eventPlanner.getBenefits();
        return benefits.getResult();
    }

    public static Map<Menu, Integer> applyAndGetGiftOrders(final Event event, final EventPlanner eventPlanner) {
        event.apply(eventPlanner);
        GiftOrders giftOrders = eventPlanner.getGiftOrders();
        return giftOrders.getOrders();
    }
}
