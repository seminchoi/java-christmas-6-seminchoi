package christmas.model.event;

import static christmas.model.event.EventKind.DECEMBER_BADGE;

import christmas.model.Badge;
import christmas.model.DecemberBadge;
import java.util.Optional;

public class DecemberBadgeEvent implements BadgeEvent {
    private final static EventKind type = DECEMBER_BADGE;

    @Override
    public Optional<Badge> apply(final int benefitAmount) {
        return DecemberBadge.findByBenefitAmount(benefitAmount);
    }

    @Override
    public EventKind getType() {
        return type;
    }
}
