package christmas.model.event;

import java.util.PriorityQueue;

public class EventManager {
    private final PriorityQueue<Event> events = new PriorityQueue<>();

    public EventManager addEvent(Event event) {
        validate(event);
        events.add(event);
        return this;
    }

    private void validate(Event event) {
        for (Event existingEvent : events) {
            if (isAlreadySetEvent(existingEvent, event)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isAlreadySetEvent(Event existingEvent, Event event) {
        return existingEvent.getClass().equals(event.getClass());
    }
}
