package christmas.model;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Orders implements Iterable<Menu> {

    protected final EnumMap<Menu, Integer> orderMenus = new EnumMap<>(Menu.class);

    @Override
    public Iterator<Menu> iterator() {
        return orderMenus.keySet().stream().iterator();
    }

    public void addOrder(Menu menu, int count) {
        orderMenus.put(menu, count);
    }
}
