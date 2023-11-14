package christmas.model.event.applicable;

import static christmas.model.menu.Menu.CHAMPAGNE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.menu.Menu;
import christmas.model.planner.EventPlanner;
import christmas.util.EventUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class ChampagneGiftEventTest {
    private static final Menu GIFT_MENU = CHAMPAGNE;
    private static final int GIFT_COUNT = 1;

    private final ChampagneGiftEvent champagneGiftEvent = new ChampagneGiftEvent();

    @DisplayName("120,000원 이상 주문 시 샴페인이 1개 증정된다.")
    @Test
    void given_orderOver_when_apply_then_appliedDiscount() {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(
                1, createOrdersMoreThanConditionAmount()
        );

        final Map<Menu, Integer> giftOrders = EventUtil.applyAndGetGiftOrders(champagneGiftEvent, eventPlanner);
        final int giftCount = giftOrders.get(GIFT_MENU);

        assertThat(giftCount).isEqualTo(GIFT_COUNT);
    }

    private Map<String, Integer> createOrdersMoreThanConditionAmount() {
        final Map<String, Integer> orders = new HashMap<>();
        orders.put("양송이수프", 20);

        return orders;
    }

    @DisplayName("120,000원 미만 주문 시 샴페인이 증정되지 않는다.")
    @Test
    void given_ordersAtNormalDay_when_apply_then_notAppliedDiscount() {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(
                1, createOrdersUnderConditionAmount()
        );

        final Map<Menu, Integer> giftOrders = EventUtil.applyAndGetGiftOrders(champagneGiftEvent, eventPlanner);
        final boolean isEventApplied = giftOrders.containsKey(GIFT_MENU);

        assertThat(isEventApplied).isEqualTo(false);
    }

    private Map<String, Integer> createOrdersUnderConditionAmount() {
        final Map<String, Integer> orders = new HashMap<>();
        orders.put("양송이수프", 10);

        return orders;
    }
}
