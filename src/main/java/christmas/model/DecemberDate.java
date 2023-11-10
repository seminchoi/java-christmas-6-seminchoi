package christmas.model;

import christmas.message.ErrorMessage;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DecemberDate {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private final LocalDate date;

    public DecemberDate(int date) {
        validate(date);
        this.date = LocalDate.of(YEAR, MONTH, date);
    }

    private void validate(int date) {
        if (isOutOfRangeDate(date)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_DATE.getMessage());
        }
    }

    private boolean isOutOfRangeDate(int date) {
        return date < MIN_DATE || date > MAX_DATE;
    }

    public Day getDay() {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return Day.of(dayOfWeek);
    }

    public int getDate() {
        return date.getDayOfMonth();
    }

    public boolean isWeekDay() {
        return getDay().isWeekDay();
    }
}
