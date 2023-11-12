package christmas.model.event;

import static christmas.model.event.EventKind.DECEMBER_BADGE;

import christmas.model.Badge;
import christmas.model.Badges;
import christmas.model.DecemberBadge;
import christmas.model.EventPlanner;
import java.util.Optional;

public class DecemberBadgeEvent implements Event {
    private final static EventKind kind = DECEMBER_BADGE;

    @Override
    public void apply(final EventPlanner eventPlanner) {
        int totalBenefitAmount = eventPlanner.sumTotalBenefitAmount();
        Optional<Badge> optionalBadge = DecemberBadge.findByBenefitAmount(totalBenefitAmount);

        Badges badges = eventPlanner.getBadges();
        optionalBadge.ifPresent(badges::add);
    }

    @Override
    public EventKind getKind() {
        return kind;
    }
}
