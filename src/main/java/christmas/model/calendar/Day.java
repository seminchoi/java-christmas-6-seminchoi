package christmas.model.calendar;

import java.time.DayOfWeek;

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

    public static Day of(DayOfWeek dayOfWeek) {
        return Day.valueOf(dayOfWeek.name());
    }

    public boolean isWeekDay() {
        return weekDayFlag;
    }
}