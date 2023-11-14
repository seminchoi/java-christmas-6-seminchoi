package christmas.model.event;

import static christmas.model.event.EventKind.DECEMBER_BADGE;

import christmas.model.badge.Badge;
import christmas.model.badge.DecemberBadge;
import christmas.model.planner.EventPlanner;

public class DecemberBadgeEvent implements Event {
    private final static EventKind kind = DECEMBER_BADGE;

    @Override
    public void apply(final EventPlanner eventPlanner) {
        int totalBenefitAmount = eventPlanner.getTotalBenefitAmount();
        Badge badge = DecemberBadge.findByBenefitAmount(totalBenefitAmount);

        eventPlanner.addBadge(kind, badge);
    }

    @Override
    public EventKind getKind() {
        return kind;
    }
}
