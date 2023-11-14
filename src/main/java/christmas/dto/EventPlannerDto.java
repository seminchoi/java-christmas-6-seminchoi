package christmas.dto;

import christmas.model.event.badge.Badge;
import christmas.model.event.result.Benefits;
import christmas.model.order.ClientOrders;
import christmas.model.order.GiftOrders;
import christmas.model.planner.EventPlanner;

public class EventPlannerDto {
    private int date;
    private int amountBeforeDiscount;
    private OrdersDto clientOrders;
    private OrdersDto giftOrders;
    private BenefitsDto benefits;
    private int benefitAmount;
    private int finalAmount;
    private BadgeDto badge;

    public static EventPlannerDto of(final EventPlanner eventPlanner) {
        return new Builder()
                .date(eventPlanner.getVisitPlanDate().getDate())
                .amountBeforeDiscount(eventPlanner.getTotalAmountBeforeDiscount())
                .clientOrders(eventPlanner.getClientOrders())
                .giftOrders(eventPlanner.getGiftOrders())
                .benefits(eventPlanner.getBenefits())
                .benefitAmount(eventPlanner.getTotalBenefitAmount())
                .finalAmount(eventPlanner.getFinalAmount())
                .badge(eventPlanner.getBadge())
                .build();
    }

    public EventPlannerDto (final Builder builder) {
        this.date = builder.date;
        this.amountBeforeDiscount = builder.amountBeforeDiscount;
        this.clientOrders = builder.clientOrders;
        this.giftOrders = builder.giftOrders;
        this.benefits = builder.benefits;
        this.benefitAmount = builder.benefitAmount;
        this.finalAmount = builder.finalAmount;
        this.badge = builder.badge;
    }

    public static class Builder {
        private int date;
        private int amountBeforeDiscount;
        private OrdersDto clientOrders;
        private OrdersDto giftOrders;
        private BenefitsDto benefits;
        private int benefitAmount;
        private int finalAmount;
        private BadgeDto badge;

        public Builder date(final int date) {
            this.date = date;
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

        public Builder benefitAmount(final int benefitAmount) {
            this.benefitAmount = benefitAmount;
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

    public int getDate() {
        return date;
    }

    public int getAmountBeforeDiscount() {
        return amountBeforeDiscount;
    }

    public OrdersDto getClientOrders() {
        return clientOrders;
    }

    public OrdersDto getGiftOrders() {
        return giftOrders;
    }

    public BenefitsDto getBenefits() {
        return benefits;
    }

    public int getBenefitAmount() {
        return benefitAmount;
    }

    public int getFinalAmount() {
        return finalAmount;
    }

    public BadgeDto getBadge() {
        return badge;
    }
}
