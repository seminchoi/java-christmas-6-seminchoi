package christmas.model;

import christmas.model.calendar.DecemberDate;
import christmas.model.event.DiscountResult;

public class EventPlanner {
    private final DecemberDate plannedVisitDate;
    private final ClientOrders clientOrders;
    private final GiftOrders giftOrders = new GiftOrders();
    private final DiscountResult discountResult = new DiscountResult();
    private final Badges badges = new Badges();

    public EventPlanner(DecemberDate plannedVisitDate, ClientOrders clientOrders) {
        this.plannedVisitDate = plannedVisitDate;
        this.clientOrders = clientOrders;
    }

    public DecemberDate getPlannedVisitDate() {
        return plannedVisitDate;
    }

    public ClientOrders getClientOrders() {
        return clientOrders;
    }

    public GiftOrders getGiftOrders() {
        return giftOrders;
    }

    public DiscountResult getDiscountResult() {
        return discountResult;
    }

    public Badges getBadges() {
        return badges;
    }

    public int sumTotalBenefitAmount() {
        int totalBenefitAmount = 0;
        totalBenefitAmount += discountResult.sumTotalDiscountAmount();
        totalBenefitAmount += giftOrders.sumTotalAmount();
        return sumTotalBenefitAmount();
    }
}
