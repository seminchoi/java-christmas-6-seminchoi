package christmas.model;

import java.util.HashSet;
import java.util.Set;

public class Badges {
    private final Set<Badge> badges = new HashSet<>();

    public void add(Badge badge) {
        badges.add(badge);
    }
}
