package christmas.model.event;

import static christmas.model.event.EventCategory.*;

public enum EventKind {
    CHRISTMAS_DISCOUNT(DISCOUNT, "크리스마스 디데이 할인"),
    WEEKDAY_DISCOUNT(DISCOUNT, "평일 할인"),
    WEEKEND_DISCOUNT(DISCOUNT, "주말 할인"),
    SPECIAL_DISCOUNT(DISCOUNT, "특별 할인"),

    MENU_GIFT(GIFT, "증정 이벤트"),

    DECEMBER_BADGE(BADGE, "12월 이벤트 배지")
    ;

    private final EventCategory category;
    private final String description;

    EventKind(EventCategory category, String description) {
        this.category = category;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public EventCategory getCategory() {
        return category;
    }
}
