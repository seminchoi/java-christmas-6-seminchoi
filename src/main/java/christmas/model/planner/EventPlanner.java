package christmas.model.planner;

import static christmas.model.event.badge.DecemberBadge.NOTHING;

import christmas.model.event.badge.Badge;
import christmas.model.calendar.DecemberDate;
import christmas.model.event.result.Benefits;
import christmas.model.menu.Menu;
import christmas.model.event.EventKind;
import christmas.model.order.ClientOrders;
import christmas.model.order.GiftOrders;

public class EventPlanner {
    private final DecemberDate visitPlanDate;
    private final ClientOrders clientOrders;
    private final GiftOrders giftOrders = new GiftOrders();
    private final Benefits benefits = new Benefits();

    private Badge badge = NOTHING;

    public EventPlanner(DecemberDate visitPlanDate, ClientOrders clientOrders) {
        this.visitPlanDate = visitPlanDate;
        this.clientOrders = clientOrders;
    }

    public void addGiftOrder(final EventKind eventKind, final Menu menu, final int count) {
        giftOrders.addOrder(menu, count);
        benefits.addResult(eventKind, calculateGiftBenefit(menu, count));
    }

    private int calculateGiftBenefit(final Menu menu, final int count) {
        return (-1) * menu.calculatePriceByPurchaseCount(count);
    }

    public void addBenefit(final EventKind eventKind, final int discountAmount) {
        benefits.addResult(eventKind, discountAmount);
    }

    public void setBadge(final Badge badge) {
        this.badge = badge;
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

    public Badge getBadge() {
        return badge;
    }
}
