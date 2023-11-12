package christmas.model.event;

public interface Event extends Comparable<Event> {
    EventKind getType();

    @Override
    default int compareTo(final Event event) {
        EventCategory category = getType().getCategory();
        EventCategory comparedCategory = event.getType().getCategory();
        return category.compareTo(comparedCategory);
    }
}
