package christmas.model.event;

import christmas.model.planner.EventPlanner;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EventManager {
    private final List<Event> events = new LinkedList<>();

    public EventManager addEvent(final Event event) {
        validate(event);
        events.add(event);
        return this;
    }

    public EventManager setUp() {
        Collections.sort(events);
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
