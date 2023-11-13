package christmas.dto;

import christmas.model.Badge;
import christmas.model.Badges;
import christmas.model.EventPlanner;
import christmas.model.Menu;
import christmas.model.Orders;
import christmas.model.event.BenefitResult;
import christmas.model.event.EventKind;
import java.util.LinkedHashMap;
import java.util.Map;

public record EventPlannerDto(
        Map<String, Integer> clientOrders,
        Map<String, Integer> giftOrders,
        Map<String, Integer> benefits,
        int totalBenefitAmount,
        int paymentAmount,
        Map<String, String> badges
) {
    public static EventPlannerDto of(final EventPlanner eventPlanner) {
        Map<String, Integer> clientOrders = convertOrders(eventPlanner.getClientOrders());
        Map<String, Integer> giftOrders = convertOrders(eventPlanner.getGiftOrders());
        Map<String, Integer>  benefits = convertBenefitResult(eventPlanner.getBenefitResult());
        int totalBenefitAmount = eventPlanner.sumTotalBenefitAmount();
        int paymentAmount = eventPlanner.calculatePaymentAmount();
        Map<String, String> badges = convertBadgeResult(eventPlanner.getBadges());

        return new EventPlannerDto(clientOrders, giftOrders, benefits, totalBenefitAmount, paymentAmount, badges);
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

    private static Map<String, Integer> convertBenefitResult(final BenefitResult benefitResult) {
        final Map<EventKind, Integer> eventToAmount = benefitResult.getResult();

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
