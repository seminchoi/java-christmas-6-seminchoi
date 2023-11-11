package christmas.model;

import java.util.EnumMap;
import java.util.Iterator;

public abstract class Orders implements Iterable<Menu> {

    protected final EnumMap<Menu, Integer> orderMenus = new EnumMap<>(Menu.class);

    @Override
    public Iterator<Menu> iterator() {
        return orderMenus.keySet().stream().iterator();
    }

    public void addOrder(Menu menu, int count) {
        orderMenus.put(menu, count);
    }

    public int getCountByMenu(Menu menu) {
        if (orderMenus.containsKey(menu)) {
            return orderMenus.get(menu);
        }
        return 0;
    }
}
