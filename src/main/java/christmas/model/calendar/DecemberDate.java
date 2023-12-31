package christmas.model.calendar;

import christmas.message.ErrorMessage;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DecemberDate {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final int CHRISTMAS_DATE = 25;

    private final LocalDate date;

    public DecemberDate(final int date) {
        validate(date);
        this.date = LocalDate.of(YEAR, MONTH, date);
    }

    private void validate(final int date) {
        if (isOutOfRangeDate(date)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }

    private boolean isOutOfRangeDate(final int date) {
        return date < MIN_DATE || date > MAX_DATE;
    }

    public Day getDay() {
        final DayOfWeek dayOfWeek = date.getDayOfWeek();
        return Day.of(dayOfWeek);
    }

    public int getDate() {
        return date.getDayOfMonth();
    }

    public boolean isWeekday() {
        return getDay().isWeekday();
    }

    public boolean isChristmas() {
        return getDate() == CHRISTMAS_DATE;
    }

    public boolean isNotOverChristmas() {
        return getDate() <= CHRISTMAS_DATE;
    }
}
