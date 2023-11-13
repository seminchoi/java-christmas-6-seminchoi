package christmas.model;

import java.util.Map;

public class GiftOrders extends Orders {
    public void addOrder(final Menu menu, final int count) {
        int currentCount = orders.getOrDefault(menu, 0);
        orders.put(menu, currentCount + count);
    }

    public void merge(GiftOrders giftOrders) {
        Map<Menu, Integer> mergedOrders = giftOrders.orders;
        orders.forEach((menu, count) -> this.orders.merge(menu, count, Integer::sum));
    }
}
