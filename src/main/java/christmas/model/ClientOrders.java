package christmas.model;

import christmas.message.ErrorMessage;

public class ClientOrders extends Orders {
    private final static int MAX_COUNT = 20;

    public void validate() {
        int totalCount = 0;
        for (Integer count : super.orders.values()) {
            totalCount += count;
        }
    }

    public void validateTotalCount(final int totalCount) {
        if (isOverMaxCount(totalCount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDERS.getMessage());
        }
    }

    private boolean isOverMaxCount(int totalCount) {
        return totalCount > MAX_COUNT;
    }
}
