package christmas.model.event;

import java.util.EnumMap;
import java.util.Map;

public class DiscountResult {
    private final Map<EventKind, Integer> result = new EnumMap<>(EventKind.class);

    public void addResult(EventKind eventKind, int discountAmount) {
        result.put(eventKind, discountAmount);
    }

    public int sumTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (Integer discountAmount : result.values()) {
            totalDiscountAmount += discountAmount;
        }
        return totalDiscountAmount;
    }
}
