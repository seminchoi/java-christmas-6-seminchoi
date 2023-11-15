package christmas.model.event.applicable;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.EventKind;
import christmas.model.planner.EventPlanner;
import christmas.util.EventUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashMap;
import java.util.Map;

public class WeekdayDiscountEventTest {
    private final static int COUNT_PER_DISCOUNT_AMOUNT = -2_023;
    private final static int TARGET_MENU_COUNT = 5;

    private final WeekdayDiscountEvent weekdayDiscountEvent = new WeekdayDiscountEvent();

    @DisplayName("평일에는 디저트 메뉴 1개당 2,023원 할인이 적용된다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    void given_ordersAtWeekday_when_apply_then_appliedDiscount(final int date) {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(date, createOrders());

        final int discountAmount = EventUtil.applyAndGetDiscountAmount(weekdayDiscountEvent, eventPlanner);

        assertThat(discountAmount).isEqualTo(COUNT_PER_DISCOUNT_AMOUNT * TARGET_MENU_COUNT);
    }

    @DisplayName("주말에는 할인이 적용되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9})
    void given_ordersAtWeekend_when_apply_then_notAppliedDiscount(final int date) {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(date, createOrders());

        final Map<EventKind, Integer> result = EventUtil.applyAndGetBenefits(weekdayDiscountEvent, eventPlanner);
        final boolean isEventApplied = result.containsKey(weekdayDiscountEvent.getKind());

        assertThat(isEventApplied).isFalse();
    }

    private Map<String, Integer> createOrders() {
        final Map<String, Integer> orders = new HashMap<>();
        // 할인 적용 메뉴 (디저트 메뉴)
        orders.put("초코케이크", TARGET_MENU_COUNT);

        orders.put("시저샐러드", 1);
        orders.put("해산물파스타", 1);
        orders.put("제로콜라", 1);

        return orders;
    }
}
