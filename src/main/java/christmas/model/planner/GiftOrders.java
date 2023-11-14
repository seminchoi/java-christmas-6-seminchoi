package christmas.model.planner;

import christmas.model.menu.Menu;

public class GiftOrders extends Orders {
    public void addOrder(final Menu menu, final int count) {
        int currentCount = orders.getOrDefault(menu, 0);
        orders.put(menu, currentCount + count);
    }
}
