package christmas.model.event.applicable;

import static christmas.model.event.EventKind.MENU_GIFT;
import static christmas.model.menu.Menu.CHAMPAGNE;

import christmas.model.event.badge.Badge;
import christmas.model.event.badge.DecemberBadge;
import christmas.model.planner.EventPlanner;
import christmas.util.EventUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class DecemberBadgeEventTest {
    private final DecemberBadgeEvent decemberBadgeEvent = new DecemberBadgeEvent();

    @DisplayName("이벤트를 적용하면 뱃지 목록에 뱃지가 추가된다.")
    @Test
    void when_apply_then_badgeAdded() {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(1, createOrders());
        eventPlanner.addGiftOrder(MENU_GIFT, CHAMPAGNE, 1);

        decemberBadgeEvent.apply(eventPlanner);
        final Badge badge = eventPlanner.getBadge();

        Assertions.assertThat(badge).isEqualTo(DecemberBadge.SANTA);
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
