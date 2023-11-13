package christmas.model;

import christmas.model.event.EventKind;
import java.util.EnumMap;
import java.util.Map;

public class GiftResult {
    Map<EventKind, GiftOrders> result = new EnumMap<>(EventKind.class);

    public void addGift(final EventKind kind, final Menu menu, final int count) {
        GiftOrders orders = result.getOrDefault(kind, new GiftOrders());
        orders.addOrder(menu, count);
    }

    public int sumTotalAmount() {
        int totalGiftMenusPrice = 0;
        for (GiftOrders orders : result.values()) {
            totalGiftMenusPrice += orders.sumTotalAmount();
        }
        return totalGiftMenusPrice;
    }

    public GiftOrders getOrders() {
        final GiftOrders giftOrders = new GiftOrders();
        for (GiftOrders orders : result.values()) {
            giftOrders.merge(orders);
        }
        return giftOrders;
    }
}