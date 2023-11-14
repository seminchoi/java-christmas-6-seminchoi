package christmas.model.calendar;

import java.time.DayOfWeek;

public enum Day {
    SUNDAY(true),
    MONDAY(true),
    TUESDAY(true),
    WEDNESDAY(true),
    THURSDAY(true),
    FRIDAY(false),
    SATURDAY(false),
    ;

    private final boolean weekdayFlag;

    Day(boolean weekdayFlag) {
        this.weekdayFlag = weekdayFlag;
    }

    public static Day of(DayOfWeek dayOfWeek) {
        return Day.valueOf(dayOfWeek.name());
    }

    public boolean isWeekday() {
        return weekdayFlag;
    }
}