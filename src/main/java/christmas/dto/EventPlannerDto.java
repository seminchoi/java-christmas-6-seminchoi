package christmas.dto;

import christmas.model.calendar.DecemberDate;
import christmas.model.event.badge.Badge;
import christmas.model.event.result.Benefits;
import christmas.model.order.ClientOrders;
import christmas.model.order.GiftOrders;
import christmas.model.planner.EventPlanner;
import java.util.StringJoiner;

public class EventPlannerDto {
    private final VisitPlanDateDto visitPlanDateDto;
    private final OrdersAmountDto ordersAmountDto;
    private final ClientOrdersDto clientOrders;
    private final GiftOrdersDto giftOrders;
    private final BenefitsDto benefits;
    private final BenefitsAmountDto benefitsAmount;
    private final PaymentAmountDto paymentAmount;
    private final BadgeDto badge;

    public static EventPlannerDto of(final EventPlanner eventPlanner) {
        return new Builder()
                .visitPlanDate(eventPlanner.getVisitPlanDate())
                .ordersAmount(eventPlanner.getOrdersAmount())
                .clientOrders(eventPlanner.getClientOrders())
                .giftOrders(eventPlanner.getGiftOrders())
                .benefits(eventPlanner.getBenefits())
                .benefitsAmount(eventPlanner.getBenefitsAmount())
                .paymentAmount(eventPlanner.getPaymentAmount())
                .badge(eventPlanner.getBadge())
                .build();
    }

    public EventPlannerDto (final Builder builder) {
        this.visitPlanDateDto = builder.visitPlanDate;
        this.ordersAmountDto = builder.ordersAmount;
        this.clientOrders = builder.clientOrders;
        this.giftOrders = builder.giftOrders;
        this.benefits = builder.benefits;
        this.benefitsAmount = builder.benefitsAmount;
        this.paymentAmount = builder.paymentAmount;
        this.badge = builder.badge;
    }

    public static class Builder {
        private VisitPlanDateDto visitPlanDate;
        private OrdersAmountDto ordersAmount;
        private ClientOrdersDto clientOrders;
        private GiftOrdersDto giftOrders;
        private BenefitsDto benefits;
        private BenefitsAmountDto benefitsAmount;
        private PaymentAmountDto paymentAmount;
        private BadgeDto badge;

        public Builder visitPlanDate(final DecemberDate decemberDate) {
            this.visitPlanDate = VisitPlanDateDto.of(decemberDate);
            return this;
        }

        public Builder ordersAmount(final int ordersAmount) {
            this.ordersAmount = new OrdersAmountDto(ordersAmount);
            return this;
        }

        public Builder clientOrders(final ClientOrders clientOrders) {
            this.clientOrders = ClientOrdersDto.of(clientOrders);
            return this;
        }

        public Builder giftOrders(final GiftOrders giftOrders) {
            this.giftOrders = GiftOrdersDto.of(giftOrders);
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

        public Builder paymentAmount(final int paymentAmount) {
            this.paymentAmount = new PaymentAmountDto(paymentAmount);
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

    @Override
    public String toString() {
        final StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(visitPlanDateDto.toString());
        stringJoiner.add(ordersAmountDto.toString());
        stringJoiner.add(clientOrders.toString());
        stringJoiner.add(giftOrders.toString());
        stringJoiner.add(benefits.toString());
        stringJoiner.add(benefitsAmount.toString());
        stringJoiner.add(paymentAmount.toString());
        stringJoiner.add(badge.toString());

        return stringJoiner.toString();
    }
}
