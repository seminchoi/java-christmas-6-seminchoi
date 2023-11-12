package christmas.model.event;

import static christmas.model.event.EventCategory.DISCOUNT;
import static christmas.model.event.EventCategory.MENU_GIFT;
import static christmas.model.event.EventCategory.BADGE;

public enum EventKind {
    CHRISTMAS_DISCOUNT(DISCOUNT, "크리스마스 디데이 할인"),
    WEEK_DAY_DISCOUNT(DISCOUNT, "평일 할인"),
    WEEKEND_DISCOUNT(DISCOUNT, "주말 할인"),
    SPECIAL_DISCOUNT(DISCOUNT, "특별 할인"),

    CHAMPAGNE_GIFT(MENU_GIFT, "증정 이벤트"),

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
