package christmas.model;

public class EventReward<T> {
    private final EventType eventType;
    private final T reword;

    public EventReward(EventType eventType, T reword) {
        this.eventType = eventType;
        this.reword = reword;
    }

    public EventType getEventType() {
        return eventType;
    }

    public T getReword() {
        return reword;
    }
}
