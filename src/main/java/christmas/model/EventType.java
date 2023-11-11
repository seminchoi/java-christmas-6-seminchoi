package christmas.model;

public enum EventType {
    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인"),
    WEEK_DAY_DISCOUNT("평일 할인"),
    WEEKEND_DISCOUNT("주말 할인"),
    SPECIAL_DISCOUNT("특별 할인"),
    MENU_GIFT("증정 이벤트");

    private final String description;

    EventType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
