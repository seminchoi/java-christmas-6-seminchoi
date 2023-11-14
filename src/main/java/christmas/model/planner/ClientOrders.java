package christmas.model.planner;

import christmas.model.menu.Menu;
import christmas.model.menu.MenuCategory;

import static christmas.message.ErrorMessage.INVALID_ORDERS;

import java.util.Map;

public class ClientOrders extends Orders {
    private final static int MIN_COUNT = 1;
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
        validateTotalCount(orderMenus);
        validateMenus(orderMenus);
    }

    private void validateTotalCount(final Map<String, Integer> orderMenus) {
        int totalCount = sumTotalCount(orderMenus);
        if (isOutOfRangeTotalCount(totalCount)) {
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

    private boolean isOutOfRangeTotalCount(final int totalCount) {
        return totalCount < MIN_COUNT || totalCount > MAX_COUNT;
    }


    private void validateMenus(final Map<String, Integer> orderMenus) {
        if(isInvalidMenus(orderMenus)) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private boolean isInvalidMenus(final Map<String, Integer> orderMenus) {
        for (String menuName : orderMenus.keySet()) {
            Menu menu = Menu.getMenuByName(menuName);
            if(canOrderIndividually(menu)) {
                return false;
            }
        }
        return true;
    }

    private boolean canOrderIndividually(final Menu menu) {
        return menu.getCategory() != MenuCategory.BEVERAGE;
    }
}
