package christmas.model.event.applicable;

import static christmas.model.event.EventKind.DECEMBER_BADGE;

import christmas.model.event.EventKind;
import christmas.model.event.badge.Badge;
import christmas.model.event.badge.DecemberBadge;
import christmas.model.planner.EventPlanner;

public class DecemberBadgeEvent implements Event {
    private final static EventKind kind = DECEMBER_BADGE;

    @Override
    public void apply(final EventPlanner eventPlanner) {
        int totalBenefitAmount = eventPlanner.getBenefitsAmount();
        final Badge badge = DecemberBadge.findByBenefitAmount(totalBenefitAmount);

        eventPlanner.setBadge(badge);
    }

    @Override
    public EventKind getKind() {
        return kind;
    }
}
