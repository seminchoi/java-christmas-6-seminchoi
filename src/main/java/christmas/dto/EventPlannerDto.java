package christmas.dto;

import christmas.model.planner.EventPlanner;
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
        BadgeDto badge
) {
    public static EventPlannerDto of(final EventPlanner eventPlanner) {
        int date = eventPlanner.getVisitPlanDate().getDate();
        int amountBeforeDiscount = eventPlanner.getTotalAmountBeforeDiscount();
        Map<String, Integer> clientOrders = OrdersDto.of(eventPlanner.getClientOrders());
        Map<String, Integer> giftOrders = OrdersDto.of(eventPlanner.getGiftOrders());
        Map<String, Integer>  benefits = convertBenefits(eventPlanner.getBenefits());
        int benefitAmount = eventPlanner.getTotalBenefitAmount();
        int finalAmount = eventPlanner.getFinalAmount();
        BadgeDto badgeDto = BadgeDto.of(eventPlanner.getBadge());

        return new EventPlannerDto(
                date, amountBeforeDiscount, clientOrders, giftOrders, benefits, benefitAmount, finalAmount, badgeDto
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
}
