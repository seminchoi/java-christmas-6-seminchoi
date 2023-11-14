package christmas.model.event.appliciable;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.EventKind;
import christmas.model.event.applicable.SpecialDiscountEvent;
import christmas.model.planner.EventPlanner;
import christmas.util.EventUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashMap;
import java.util.Map;

public class SpecialDiscountEventTest {
    private final static int DISCOUNT_AMOUNT = -1_000;
    private final SpecialDiscountEvent specialDiscountEvent = new SpecialDiscountEvent();


    @DisplayName("일요일이나 크리스마스에는 특별 할인 1,000원이 적용된다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 31, 25})
    void given_ordersAtSpecialDay_when_apply_then_appliedDiscount(final int date) {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(date, createOrders());

        final int discountAmount = EventUtil.applyAndGetDiscountAmount(specialDiscountEvent, eventPlanner);

        assertThat(discountAmount).isEqualTo(DISCOUNT_AMOUNT);
    }

    @DisplayName("일요일이나 크리스마스 외에는 특별할인이 적용되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 11, 26})
    void given_ordersAtNormalDay_when_apply_then_notAppliedDiscount(final int date) {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(date, createOrders());

        final Map<EventKind, Integer> result = EventUtil.applyAndGetBenefitResult(specialDiscountEvent, eventPlanner);
        final boolean isEventApplied = result.containsKey(specialDiscountEvent.getKind());

        assertThat(isEventApplied).isEqualTo(false);
    }


    private Map<String, Integer> createOrders() {
        final Map<String, Integer> orders = new HashMap<>();
        orders.put("시저샐러드", 5);
        orders.put("해산물파스타", 5);
        orders.put("초코케이크", 5);
        orders.put("제로콜라", 5);

        return orders;
    }
}
