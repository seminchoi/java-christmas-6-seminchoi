package christmas.model.event;

import static christmas.model.event.EventClassification.DISCOUNT;
import static christmas.model.event.EventClassification.MENU_GIFT;
import static christmas.model.event.EventClassification.BADGE;

public enum EventType {
    CHRISTMAS_DISCOUNT(DISCOUNT, "크리스마스 디데이 할인"),
    WEEK_DAY_DISCOUNT(DISCOUNT, "평일 할인"),
    WEEKEND_DISCOUNT(DISCOUNT, "주말 할인"),
    SPECIAL_DISCOUNT(DISCOUNT, "특별 할인"),

    CHAMPAGNE_GIFT(MENU_GIFT, "증정 이벤트"),

    DECEMBER_BADGE(BADGE, "12월 이벤트 배지")
    ;

    private final EventClassification classification;
    private final String description;

    EventType(EventClassification classification, String description) {
        this.classification = classification;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public EventClassification getClassification() {
        return classification;
    }
}
