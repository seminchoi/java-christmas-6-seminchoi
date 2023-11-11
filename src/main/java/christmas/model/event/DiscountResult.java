package christmas.model.event;

import java.util.EnumMap;
import java.util.Map;

public class DiscountResult {
    private final Map<EventType, Integer> result = new EnumMap<>(EventType.class);
}
