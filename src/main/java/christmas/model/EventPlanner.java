package christmas.model;

import christmas.model.calendar.DecemberDate;
import christmas.model.event.BenefitResult;
import christmas.model.event.EventKind;

public class EventPlanner {
    private final DecemberDate visitPlanDate;
    private final ClientOrders clientOrders;
    private final GiftOrders giftOrders = new GiftOrders();
    private final BenefitResult benefitResult = new BenefitResult();
    private final Badges badges = new Badges();

    public EventPlanner(DecemberDate visitPlanDate, ClientOrders clientOrders) {
        this.visitPlanDate = visitPlanDate;
        this.clientOrders = clientOrders;
    }

    public void addGiftOrder(final EventKind eventKind, final Menu menu, final int count) {
        giftOrders.addOrder(menu, count);
        benefitResult.addResult(eventKind, (-1) * menu.getPrice() * count);
    }

    public void addBenefitResult(final EventKind eventKind, final int discountAmount) {
        benefitResult.addResult(eventKind, discountAmount);
    }

    public void addBadge(final EventKind eventKind, final Badge badge) {
        badges.add(eventKind, badge);
    }

    public int getTotalAmountBeforeDiscount() {
        return clientOrders.sumTotalAmount();
    }

    public int getTotalBenefitAmount() {
        return benefitResult.sumTotalBenefitAmount();
    }

    public int getFinalAmount() {
        int totalAmount = clientOrders.sumTotalAmount() + giftOrders.sumTotalAmount();
        return totalAmount + getTotalBenefitAmount();
    }

    public DecemberDate getVisitPlanDate() {
        return visitPlanDate;
    }

    public ClientOrders getClientOrders() {
        return clientOrders;
    }

    public GiftOrders getGiftOrders() {
        return giftOrders;
    }

    public BenefitResult getBenefitResult() {
        return benefitResult;
    }

    public Badges getBadges() {
        return badges;
    }
}
