package christmas.dto;

import christmas.model.event.badge.Badge;
import christmas.model.event.result.Badges;
import christmas.model.planner.EventPlanner;
import christmas.model.menu.Menu;
import christmas.model.order.Orders;
import christmas.model.event.result.Benefits;
import christmas.model.event.EventKind;
import java.util.LinkedHashMap;
import java.util.Map;

public record EventPlannerDto(
        int date,
        int amountBeforeDiscount,
        Map<String, Integer> clientOrders,
        Map<String, Integer> giftOrders,
        Map<String, Integer> benefits,
        int benefitAmount,
        int finalAmount,
        Map<String, String> badges
) {
    public static EventPlannerDto of(final EventPlanner eventPlanner) {
        int date = eventPlanner.getVisitPlanDate().getDate();
        int amountBeforeDiscount = eventPlanner.getTotalAmountBeforeDiscount();
        Map<String, Integer> clientOrders = convertOrders(eventPlanner.getClientOrders());
        Map<String, Integer> giftOrders = convertOrders(eventPlanner.getGiftOrders());
        Map<String, Integer>  benefits = convertBenefits(eventPlanner.getBenefits());
        int benefitAmount = eventPlanner.getTotalBenefitAmount();
        int finalAmount = eventPlanner.getFinalAmount();
        Map<String, String> badges = convertBadgeResult(eventPlanner.getBadges());

        return new EventPlannerDto(
                date, amountBeforeDiscount, clientOrders, giftOrders, benefits, benefitAmount, finalAmount, badges
        );
    }

    private static Map<String, Integer> convertOrders(final Orders orders) {
        final Map<Menu, Integer> menuToCount = orders.getOrders();
        return menuToCount.entrySet()
                .stream()
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey().getName(), entry.getValue()),
                        Map::putAll
                );
    }

    private static Map<String, Integer> convertBenefits(final Benefits benefits) {
        final Map<EventKind, Integer> eventToAmount = benefits.getResult();

        return eventToAmount.entrySet()
                .stream()
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey().getDescription(), entry.getValue()),
                        Map::putAll
                );
    }

    private static Map<String, String> convertBadgeResult(final Badges badges) {
        final Map<EventKind, Badge> eventToBadge = badges.getBadges();

        return eventToBadge.entrySet()
                .stream()
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey().getDescription(), entry.getValue().getDescription()),
                        Map::putAll
                );
    }
}
