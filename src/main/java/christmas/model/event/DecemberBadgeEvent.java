package christmas.model.event;

import static christmas.model.event.EventType.DECEMBER_BADGE;

import christmas.model.Badge;
import christmas.model.DecemberBadge;
import java.util.Optional;

public class DecemberBadgeEvent implements BadgeEvent {
    private final static EventType type = DECEMBER_BADGE;

    @Override
    public Optional<Badge> apply(final int benefitAmount) {
        return DecemberBadge.findByBenefitAmount(benefitAmount);
    }

    @Override
    public EventType getType() {
        return type;
    }
}
