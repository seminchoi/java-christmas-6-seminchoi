package christmas.model.calendar;

import static christmas.model.calendar.Day.SUNDAY;
import static christmas.model.calendar.Day.MONDAY;
import static christmas.model.calendar.Day.TUESDAY;
import static christmas.model.calendar.Day.WEDNESDAY;
import static christmas.model.calendar.Day.THURSDAY;
import static christmas.model.calendar.Day.FRIDAY;
import static christmas.model.calendar.Day.SATURDAY;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.util.List;

class DayTest {

    @DisplayName("DayofWeek 객체를 Day 객체로 변환할 때 예외가 발생하지 않는다.")
    @Test
    void given_dayOfWeek_when_of_then_noException() {
        final DayOfWeek[] dayOfWeeks = DayOfWeek.values();

        for (final DayOfWeek dayOfWeek : dayOfWeeks) {
            Day.of(dayOfWeek);
        }
    }

    @DisplayName("일,월,화,수,목요일은 평일이다.")
    @Test
    void given_weekDays_when_isWeekDay_then_true() {
        final List<Day> days = List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY);

        for (final Day day : days) {
            final boolean isWeekDay = day.isWeekday();
            assertThat(isWeekDay).isTrue();
        }
    }

    @DisplayName("금,토 요일은 평일이 아니다.")
    @Test
    void given_weekends_when_isWeekDay_then_false() {
        final List<Day> days = List.of(FRIDAY, SATURDAY);

        for (final Day day : days) {
            final boolean isWeekDay = day.isWeekday();
            assertThat(isWeekDay).isFalse();
        }
    }
}
