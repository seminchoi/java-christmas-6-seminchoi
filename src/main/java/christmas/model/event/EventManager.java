package christmas.model.event;

import christmas.model.EventPlanner;

import java.util.PriorityQueue;

public class EventManager {
    private final PriorityQueue<Event> events = new PriorityQueue<>();

    public EventManager addEvent(final Event event) {
        validate(event);
        events.add(event);
        return this;
    }

    private void validate(final Event event) {
        for (Event existingEvent : events) {
            if (isAlreadySetEvent(existingEvent, event)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isAlreadySetEvent(final Event existingEvent, final Event event) {
        return existingEvent.getClass().equals(event.getClass());
    }

    public void applyEvents(final EventPlanner eventPlanner) {
        for (Event event : events) {
            event.apply(eventPlanner);
        }
    }
}
