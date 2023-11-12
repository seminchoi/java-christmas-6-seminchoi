package christmas.model.event;

public interface Event extends Comparable<Event> {
    EventType getType();

    @Override
    default int compareTo(final Event event) {
        EventClassification category = getType().getClassification();
        EventClassification comparedCategory = event.getType().getClassification();
        return category.compareTo(comparedCategory);
    }
}
