package christmas.model.calendar;

import static christmas.model.calendar.Day.SUNDAY;
import static christmas.model.calendar.Day.MONDAY;
import static christmas.model.calendar.Day.TUESDAY;
import static christmas.model.calendar.Day.WEDNESDAY;
import static christmas.model.calendar.Day.THURSDAY;
import static christmas.model.calendar.Day.FRIDAY;
import static christmas.model.calendar.Day.SATURDAY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DecemberDateTest {
    @DisplayName("유효하지 않은 날짜를 통해 생성하려 하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32})
    void given_invalidDate_when_constructor_then_throwException(final int date) {
        assertThatThrownBy(() -> new DecemberDate(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("올바른 날짜를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 31})
    void given_decemberDate_when_getDate_then_sameDate(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final int resultDate = decemberDate.getDate();

        assertThat(resultDate).isEqualTo(date);
    }

    @DisplayName("일요일을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 31})
    void given_sundayDate_when_getDay_then_sunday(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final Day day = decemberDate.getDay();

        assertThat(day).isEqualTo(SUNDAY);
    }

    @ParameterizedTest
    @DisplayName("월요일을 반환한다.")
    @ValueSource(ints = {4, 11, 18, 25})
    void given_mondayDate_when_getDay_then_monday(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final Day day = decemberDate.getDay();

        assertThat(day).isEqualTo(MONDAY);
    }

    @DisplayName("화요일을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {5, 12, 19, 26})
    void given_tuesdayDate_when_getDay_then_tuesday(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final Day day = decemberDate.getDay();

        assertThat(day).isEqualTo(TUESDAY);
    }

    @DisplayName("수요일을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {6, 13, 20, 27})
    void given_wednesdayDate_when_getDay_then_wednesday(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final Day day = decemberDate.getDay();

        assertThat(day).isEqualTo(WEDNESDAY);
    }

    @DisplayName("목요일을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 14, 21, 28})
    void given_thursdayDate_when_getDay_then_thursday(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final Day day = decemberDate.getDay();

        assertThat(day).isEqualTo(THURSDAY);
    }

    @DisplayName("금요일을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 8, 15, 22, 29})
    void given_fridayDate_when_getDay_then_friday(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final Day day = decemberDate.getDay();

        assertThat(day).isEqualTo(FRIDAY);
    }

    @DisplayName("토요일을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 9, 16, 23, 30})
    void given_saturdayDate_when_getDay_then_saturday(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final Day day = decemberDate.getDay();

        assertThat(day).isEqualTo(SATURDAY);
    }

    @DisplayName("평일인지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7})
    void given_weekdayDate_when_isWeekday_then_true(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final boolean isWeekday = decemberDate.isWeekday();

        assertThat(isWeekday).isTrue();
    }

    @DisplayName("주말인지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void given_weekendDate_when_isWeekday_then_false(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final boolean isWeekday = decemberDate.isWeekday();

        assertThat(isWeekday).isFalse();
    }

    @DisplayName("크리스마스인지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {25})
    void given_christmasDate_when_isChristmas_then_true(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final boolean isChristmas = decemberDate.isChristmas();

        assertThat(isChristmas).isTrue();
    }

    @DisplayName("크리스마스가 지나지 않았는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {24, 25})
    void given_beforeChristmasDate_when_isNotOverChristmas_then_true(final int date) {
        final DecemberDate decemberDate = new DecemberDate(date);

        final boolean isNotOverChristmas = decemberDate.isNotOverChristmas();

        assertThat(isNotOverChristmas).isTrue();
    }
}
