package christmas.model;

import static christmas.message.ErrorMessage.INVALID_ORDERS;

import java.util.Map;

public class ClientOrders extends Orders {
    private final static int MAX_COUNT = 20;

    public ClientOrders(final Map<String, Integer> orderMenus) {
        validate(orderMenus);
        for (String menuName : orderMenus.keySet()) {
            Menu menu = Menu.getMenuByName(menuName);
            int count = orderMenus.get(menuName);
            orders.put(menu, count);
        }
    }

    private void validate(final Map<String, Integer> orderMenus) {
        int totalCount = sumTotalCount(orderMenus);
        if (isOverTotalCount(totalCount)) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private int sumTotalCount(final Map<String, Integer> orderMenus) {
        int totalCount = 0;
        for (Integer count : orderMenus.values()) {
            totalCount += count;
        }
        return totalCount;
    }

    private boolean isOverTotalCount(final int totalCount) {
        return totalCount > MAX_COUNT;
    }
}
