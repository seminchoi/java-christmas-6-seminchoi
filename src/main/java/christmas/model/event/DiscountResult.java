package christmas.model.event;

import java.util.EnumMap;
import java.util.Map;

public class DiscountResult {
    private final Map<EventType, Integer> result = new EnumMap<>(EventType.class);

    public void addResult(EventType eventType, int discountAmount) {
        result.put(eventType, discountAmount);
    }
}
