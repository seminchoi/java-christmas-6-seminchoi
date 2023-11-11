package christmas.model.event;

import christmas.model.Badge;

import java.util.Optional;

public interface BadgeEvent extends Event {
    Optional<Badge> apply(int amount);
}
