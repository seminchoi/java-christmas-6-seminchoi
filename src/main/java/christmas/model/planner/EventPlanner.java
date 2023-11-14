package christmas.model.planner;

import christmas.model.badge.Badge;
import christmas.model.calendar.DecemberDate;
import christmas.model.menu.Menu;
import christmas.model.event.EventKind;

public class EventPlanner {
    private final DecemberDate visitPlanDate;
    private final ClientOrders clientOrders;
    private final GiftOrders giftOrders = new GiftOrders();
    private final Benefits benefits = new Benefits();
    private final Badges badges = new Badges();

    public EventPlanner(DecemberDate visitPlanDate, ClientOrders clientOrders) {
        this.visitPlanDate = visitPlanDate;
        this.clientOrders = clientOrders;
    }

    public void addGiftOrder(final EventKind eventKind, final Menu menu, final int count) {
        giftOrders.addOrder(menu, count);
        benefits.addResult(eventKind, (-1) * menu.getPrice() * count);
    }

    public void addBenefit(final EventKind eventKind, final int discountAmount) {
        benefits.addResult(eventKind, discountAmount);
    }

    public void addBadge(final EventKind eventKind, final Badge badge) {
        badges.add(eventKind, badge);
    }

    public int getTotalAmountBeforeDiscount() {
        return clientOrders.sumTotalAmount();
    }

    public int getTotalBenefitAmount() {
        return benefits.sumTotalBenefitAmount();
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

    public Benefits getBenefits() {
        return benefits;
    }

    public Badges getBadges() {
        return badges;
    }
}
