package christmas.model.planner;

import static christmas.model.event.EventKind.MENU_GIFT;
import static christmas.model.menu.Menu.CHAMPAGNE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.EventKind;
import christmas.model.event.applicable.ChampagneGiftEvent;
import christmas.model.event.applicable.ChristmasDiscountEvent;
import christmas.model.event.result.Benefits;
import christmas.model.menu.Menu;
import christmas.util.EventUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class EventPlannerTest {
    @DisplayName("증정 메뉴는 혜택에 포함된다.")
    @Test
    void given_gift_when_addGiftOrder_then_addBenefit() {
        final EventKind eventKind = MENU_GIFT;
        final Menu menu = CHAMPAGNE;

        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(1, EventUtil.createTestOrders());
        eventPlanner.addGiftOrder(eventKind, menu, 1);

        final Benefits benefits = eventPlanner.getBenefits();
        final Map<EventKind, Integer> result = benefits.getResult();
        final int giftAmount = result.get(eventKind);

        assertThat(giftAmount).isEqualTo((-1) * menu.getPrice());
    }

    @DisplayName("할인 후 예상 결제 금액을 계산한다.")
    @Test
    void given_discountAndGift_when_getFinalAmount_then_correctAmount() {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(1, EventUtil.createTestOrders());
        final ChristmasDiscountEvent christmasDiscountEvent = new ChristmasDiscountEvent();
        final ChampagneGiftEvent champagneGiftEvent = new ChampagneGiftEvent();
        christmasDiscountEvent.apply(eventPlanner);
        champagneGiftEvent.apply(eventPlanner);

        final int finalAmount = eventPlanner.getFinalAmount();
        final int expectFinalAmount = eventPlanner.getOrdersAmount() - 1_000;

        assertThat(finalAmount).isEqualTo(expectFinalAmount);
    }
}
