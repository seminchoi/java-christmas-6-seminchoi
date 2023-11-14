package christmas.dto;

import christmas.model.planner.EventPlanner;

public record EventPlannerDto(
        int date,
        int amountBeforeDiscount,
        OrdersDto clientOrders,
        OrdersDto giftOrders,
        BenefitsDto benefits,
        int benefitAmount,
        int finalAmount,
        BadgeDto badge
) {
    public static EventPlannerDto of(final EventPlanner eventPlanner) {
        int date = eventPlanner.getVisitPlanDate().getDate();
        int amountBeforeDiscount = eventPlanner.getTotalAmountBeforeDiscount();
        OrdersDto clientOrders = OrdersDto.of(eventPlanner.getClientOrders());
        OrdersDto giftOrders = OrdersDto.of(eventPlanner.getGiftOrders());
        BenefitsDto benefits = BenefitsDto.of(eventPlanner.getBenefits());
        int benefitAmount = eventPlanner.getTotalBenefitAmount();
        int finalAmount = eventPlanner.getFinalAmount();
        BadgeDto badgeDto = BadgeDto.of(eventPlanner.getBadge());

        return new EventPlannerDto(
                date, amountBeforeDiscount, clientOrders, giftOrders, benefits, benefitAmount, finalAmount, badgeDto
        );
    }
}
