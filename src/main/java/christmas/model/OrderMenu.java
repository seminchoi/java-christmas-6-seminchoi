package christmas.model;

import java.util.EnumMap;

public class OrderMenu {
    private final EnumMap<Menu, Integer> orderMenus = new EnumMap<>(Menu.class);

    public void addOrder(Menu menu, int count) {
        orderMenus.put(menu, count);
    }
}
