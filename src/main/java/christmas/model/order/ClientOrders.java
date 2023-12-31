package christmas.model.order;

import static christmas.message.ErrorMessage.INVALID_ORDERS;

import christmas.model.menu.Menu;
import java.util.Map;

public class ClientOrders extends Orders {
    private final static int MIN_COUNT = 1;
    private final static int MAX_COUNT = 20;

    public ClientOrders(final Map<String, Integer> orderMenus) {
        validate(orderMenus);
        for (String menuName : orderMenus.keySet()) {
            final Menu menu = Menu.getMenuByName(menuName);
            final int count = orderMenus.get(menuName);
            orders.put(menu, count);
        }
    }

    private void validate(final Map<String, Integer> orderMenus) {
        validateTotalCount(orderMenus);
        validateMenus(orderMenus);
    }

    private void validateTotalCount(final Map<String, Integer> orderMenus) {
        final int totalCount = sumTotalCount(orderMenus);
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
        if(hasIndividualOrderPossibleMenu(orderMenus)) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private boolean hasIndividualOrderPossibleMenu(final Map<String, Integer> orderMenus) {
        for (String menuName : orderMenus.keySet()) {
            final Menu menu = Menu.getMenuByName(menuName);
            if(menu.isIndividualOrderPossible()) {
                return false;
            }
        }
        return true;
    }
}
