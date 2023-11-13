package christmas.model;

import christmas.model.event.EventKind;
import java.util.EnumMap;
import java.util.Map;

public class Badges {
    private final Map<EventKind, Badge> badges = new EnumMap<>(EventKind.class);

    public void add(EventKind eventKind, Badge badge) {
        badges.put(eventKind, badge);
    }
}
