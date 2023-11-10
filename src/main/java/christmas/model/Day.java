package christmas.model;

public enum Day {
    SUNDAY(true),
    MONDAY(true),
    TUESDAY(true),
    WENDESDAY(true),
    THURSDAY(true),
    FRIDAY(false),
    SATURDAY(false),
    ;

    private final boolean weekDayFlag;

    Day(boolean weekDayFlag) {
        this.weekDayFlag = weekDayFlag;
    }

    public boolean isWeekDay() {
        return weekDayFlag;
    }
}