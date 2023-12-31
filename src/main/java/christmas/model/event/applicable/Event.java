package christmas.model.event.applicable;

import christmas.model.event.EventCategory;
import christmas.model.event.EventKind;
import christmas.model.planner.EventPlanner;

public interface Event extends Comparable<Event> {
    EventKind getKind();

    void apply(final EventPlanner eventPlanner);

    @Override
    default int compareTo(final Event event) {
        final EventCategory category = getKind().getCategory();
        final EventCategory comparedCategory = event.getKind().getCategory();
        return category.compareTo(comparedCategory);
    }
}
