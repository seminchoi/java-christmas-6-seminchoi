package christmas.model;

import java.util.EnumMap;
import java.util.Iterator;

public abstract class Orders implements Iterable<Menu> {

    protected final EnumMap<Menu, Integer> orderMenus = new EnumMap<>(Menu.class);

    @Override
    public Iterator<Menu> iterator() {
        return orderMenus.keySet().stream().iterator();
    }

    public void addOrder(final Menu menu, final int count) {
        orderMenus.put(menu, count);
    }

    public int getCountByMenu(final Menu menu) {
        if (orderMenus.containsKey(menu)) {
            return orderMenus.get(menu);
        }
        return 0;
    }

    public int sumTotalAmount() {
        int totalAmount = 0;
        for (Menu menu : orderMenus.keySet()) {
            totalAmount += calculateMenuAmount(menu);
        }
        return totalAmount;
    }

    private int calculateMenuAmount(final Menu menu) {
        int menuOrderCount = orderMenus.get(menu);
        return menu.getPrice() * menuOrderCount;
    }
}
