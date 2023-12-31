package christmas.model.event.applicable;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.util.EventUtil;
import christmas.model.event.EventKind;
import christmas.model.planner.EventPlanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class ChristmasDiscountEventTest {
    private final ChristmasDiscountEvent event = new ChristmasDiscountEvent();

    @DisplayName("크리스마스 이벤트는 1일에 할인 금액 1,000원으로 시작한다.")
    @Test
    void given_1stDate_when_apply_then_discountAmount() {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(1, EventUtil.createTestOrders());

        final int discountAmount = EventUtil.applyAndGetDiscountAmount(event, eventPlanner);

        assertThat(discountAmount).isEqualTo(-1_000);
    }

    @DisplayName("크리스마스 이벤트는 1일이 지날 때마다 할인 금액이 100원 증가한다.")
    @Test
    void given_2ndDate_when_apply_then_discountAmount() {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(2, EventUtil.createTestOrders());

        final int discountAmount = EventUtil.applyAndGetDiscountAmount(event, eventPlanner);

        assertThat(discountAmount).isEqualTo(-1_100);
    }

    @DisplayName("크리스마스 이벤트는 크리스마스가 끝난 후 이벤트가 종료된다.")
    @Test
    void given_26thDate_when_apply_then_discountAmount() {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(26, EventUtil.createTestOrders());

        final Map<EventKind, Integer> result = EventUtil.applyAndGetBenefits(event, eventPlanner);
        final boolean isEventApplied = result.containsKey(event.getKind());

        assertThat(isEventApplied).isEqualTo(false);
    }
}
