package christmas.model;

import christmas.message.ErrorMessage;

public class ClientOrderMenu extends OrderMenu {
    private final static int MAX_COUNT = 20;

    public void validate() {
        int totalCount = 0;
        for (Integer count : super.orderMenus.values()) {
            totalCount += count;
        }
    }

    public void validateTotalCount(int totalCount) {
        if (isOverMaxCount(totalCount)) {
            throw new IllegalArgumentException(ErrorMessage.TOO_MANY_ORDERS.getMessage());
        }
    }

    private boolean isOverMaxCount(int totalCount) {
        return totalCount > MAX_COUNT;
    }
}
