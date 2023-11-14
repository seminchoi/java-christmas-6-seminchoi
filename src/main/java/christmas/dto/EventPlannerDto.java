package christmas.dto;

import christmas.model.calendar.DecemberDate;
import christmas.model.event.badge.Badge;
import christmas.model.event.result.Benefits;
import christmas.model.order.ClientOrders;
import christmas.model.order.GiftOrders;
import christmas.model.planner.EventPlanner;

public class EventPlannerDto {
    private VisitPlanDateDto visitPlanDateDto;
    private int amountBeforeDiscount;
    private OrdersDto clientOrders;
    private OrdersDto giftOrders;
    private BenefitsDto benefits;
    private BenefitsAmountDto benefitsAmount;
    private int finalAmount;
    private BadgeDto badge;

    public static EventPlannerDto of(final EventPlanner eventPlanner) {
        return new Builder()
                .visitPlanDate(eventPlanner.getVisitPlanDate())
                .amountBeforeDiscount(eventPlanner.getTotalAmountBeforeDiscount())
                .clientOrders(eventPlanner.getClientOrders())
                .giftOrders(eventPlanner.getGiftOrders())
                .benefits(eventPlanner.getBenefits())
                .benefitsAmount(eventPlanner.getTotalBenefitAmount())
                .finalAmount(eventPlanner.getFinalAmount())
                .badge(eventPlanner.getBadge())
                .build();
    }

    public EventPlannerDto (final Builder builder) {
        this.visitPlanDateDto = builder.visitPlanDate;
        this.amountBeforeDiscount = builder.amountBeforeDiscount;
        this.clientOrders = builder.clientOrders;
        this.giftOrders = builder.giftOrders;
        this.benefits = builder.benefits;
        this.benefitsAmount = builder.benefitsAmount;
        this.finalAmount = builder.finalAmount;
        this.badge = builder.badge;
    }

    public static class Builder {
        private VisitPlanDateDto visitPlanDate;
        private int amountBeforeDiscount;
        private OrdersDto clientOrders;
        private OrdersDto giftOrders;
        private BenefitsDto benefits;
        private BenefitsAmountDto benefitsAmount;
        private int finalAmount;
        private BadgeDto badge;

        public Builder visitPlanDate(final DecemberDate decemberDate) {
            this.visitPlanDate = VisitPlanDateDto.of(decemberDate);
            return this;
        }

        public Builder amountBeforeDiscount(final int amountBeforeDiscount) {
            this.amountBeforeDiscount = amountBeforeDiscount;
            return this;
        }

        public Builder clientOrders(final ClientOrders clientOrders) {
            this.clientOrders = OrdersDto.of(clientOrders);
            return this;
        }

        public Builder giftOrders(final GiftOrders giftOrders) {
            this.giftOrders = OrdersDto.of(giftOrders);
            return this;
        }

        public Builder benefits(final Benefits benefits) {
            this.benefits = BenefitsDto.of(benefits);
            return this;
        }

        public Builder benefitsAmount(final int benefitAmount) {
            this.benefitsAmount = new BenefitsAmountDto(benefitAmount);
            return this;
        }

        public Builder finalAmount(final int finalAmount) {
            this.finalAmount = finalAmount;
            return this;
        }

        public Builder badge(final Badge badge) {
            this.badge = BadgeDto.of(badge);
            return this;
        }

        public EventPlannerDto build() {
            return new EventPlannerDto(this);
        }
    }
}
