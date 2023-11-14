package christmas.model.event.appliciable;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.util.EventUtil;
import christmas.model.event.EventKind;
import christmas.model.event.applicable.ChristmasDiscountEvent;
import christmas.model.planner.EventPlanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class ChristmasDiscountEventTest {
    private final ChristmasDiscountEvent event = new ChristmasDiscountEvent();

    @DisplayName("크리스마스 이벤트는 1일에 할인 금액 1,000원으로 시작한다.")
    @Test
    void given_1stDate_when_apply_then_discountAmount() {
        EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(1, createOrders());

        int discountAmount = EventUtil.applyAndGetDiscountAmount(event, eventPlanner);

        assertThat(discountAmount).isEqualTo(-1_000);
    }

    @DisplayName("크리스마스 이벤트는 1일이 지날 때마다 할인 금액이 100원 증가한다.")
    @Test
    void given_2ndDate_when_apply_then_discountAmount() {
        EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(2, createOrders());

        int discountAmount = EventUtil.applyAndGetDiscountAmount(event, eventPlanner);

        assertThat(discountAmount).isEqualTo(-1_100);
    }

    @DisplayName("크리스마스 이벤트는 크리스마스가 끝난 후 이벤트가 종료된다.")
    @Test
    void given_26thDate_when_apply_then_discountAmount() {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(26, createOrders());

        Map<EventKind, Integer> result = EventUtil.applyAndGetBenefitResult(event, eventPlanner);
        boolean isEventApplied = result.containsKey(event.getKind());

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
