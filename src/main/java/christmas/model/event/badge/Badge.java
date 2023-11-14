package christmas.model.event.badge;

import christmas.model.event.EventKind;

public interface Badge {
    EventKind getEventKind();
    String getDescription();
}
