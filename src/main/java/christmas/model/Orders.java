package christmas.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Orders implements Iterable<Menu> {

    protected final Map<Menu, Integer> orders = new EnumMap<>(Menu.class);

    @Override
    public Iterator<Menu> iterator() {
        return orders.keySet().stream().iterator();
    }

    public void addOrder(final Menu menu, final int count) {
        orders.put(menu, count);
    }

    public int getCountByMenu(final Menu menu) {
        if (orders.containsKey(menu)) {
            return orders.get(menu);
        }
        return 0;
    }

    public int sumTotalAmount() {
        int totalAmount = 0;
        for (Menu menu : orders.keySet()) {
            totalAmount += calculateMenuAmount(menu);
        }
        return totalAmount;
    }

    private int calculateMenuAmount(final Menu menu) {
        int menuOrderCount = orders.get(menu);
        return menu.getPrice() * menuOrderCount;
    }

    public Map<Menu, Integer> getOrders() {
        return Collections.unmodifiableMap(orders);
    }
}
