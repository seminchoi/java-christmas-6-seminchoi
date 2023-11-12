package christmas.model.event;

import christmas.model.EventPlanner;

public interface Event extends Comparable<Event> {
    EventKind getKind();

    void apply(final EventPlanner eventPlanner);

    @Override
    default int compareTo(final Event event) {
        EventCategory category = getKind().getCategory();
        EventCategory comparedCategory = event.getKind().getCategory();
        return category.compareTo(comparedCategory);
    }
}
