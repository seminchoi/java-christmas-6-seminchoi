package christmas.model;

import christmas.model.calendar.DecemberDate;
import christmas.model.event.DiscountResult;
import christmas.model.event.EventKind;
import java.util.Map;

public class EventPlanner {
    private final DecemberDate visitPlanDate;
    private final ClientOrders clientOrders;
    private final GiftResult giftResult = new GiftResult();
    private final DiscountResult discountResult = new DiscountResult();
    private final Badges badges = new Badges();

    public EventPlanner(DecemberDate visitPlanDate, ClientOrders clientOrders) {
        this.visitPlanDate = visitPlanDate;
        this.clientOrders = clientOrders;
    }

    public void addGiftOrder(final EventKind eventKind, final Menu menu, final int count) {
        giftResult.addGiftOrder(eventKind, menu, count);
    }

    public void addDiscountResult(final EventKind eventKind, final int discountAmount) {
        discountResult.addResult(eventKind, discountAmount);
    }


    public DecemberDate getVisitPlanDate() {
        return visitPlanDate;
    }

    public ClientOrders getClientOrders() {
        return clientOrders;
    }

    public GiftOrders getGiftOrders() {
        return giftResult.getOrders();
    }

    public Map<EventKind, Integer> getDiscountResult() {
        return discountResult.getResult();
    }

    public Badges getBadges() {
        return badges;
    }

    public int sumTotalBenefitAmount() {
        int totalBenefitAmount = 0;
        totalBenefitAmount += discountResult.sumTotalDiscountAmount();
        totalBenefitAmount += giftResult.sumTotalAmount();
        return totalBenefitAmount;
    }
}
