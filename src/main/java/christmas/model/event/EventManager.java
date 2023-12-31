package christmas.model.event;

import christmas.model.event.applicable.Event;
import christmas.model.order.ClientOrders;
import christmas.model.planner.EventPlanner;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EventManager {
    private final static int MIN_ORDER_AMOUNT_FOR_EVENT = 10_000;
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
        if(isEventApplicable(eventPlanner)) {
            events.forEach(event -> event.apply(eventPlanner));
        }
    }

    private boolean isEventApplicable(final EventPlanner eventPlanner) {
        ClientOrders clientOrders = eventPlanner.getClientOrders();
        return clientOrders.sumTotalAmount() >= MIN_ORDER_AMOUNT_FOR_EVENT;
    }
}
