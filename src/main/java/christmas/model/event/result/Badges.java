package christmas.model.event.result;

import christmas.model.event.EventKind;
import christmas.model.event.badge.Badge;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class Badges {
    private final Map<EventKind, Badge> badges = new EnumMap<>(EventKind.class);

    public void add(EventKind eventKind, Badge badge) {
        badges.put(eventKind, badge);
    }

    public Map<EventKind, Badge> getBadges() {
        return Collections.unmodifiableMap(badges);
    }
}
