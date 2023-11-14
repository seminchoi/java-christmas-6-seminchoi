package christmas.model.event.applicable;

import static christmas.model.event.EventKind.MENU_GIFT;
import static christmas.model.menu.Menu.CHAMPAGNE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.badge.Badge;
import christmas.model.event.badge.DecemberBadge;
import christmas.model.planner.EventPlanner;
import christmas.util.EventUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DecemberBadgeEventTest {
    private final DecemberBadgeEvent decemberBadgeEvent = new DecemberBadgeEvent();

    @DisplayName("이벤트를 적용하면 뱃지 목록에 뱃지가 추가된다.")
    @Test
    void when_apply_then_badgeAdded() {
        final EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(1, EventUtil.createTestOrders());
        eventPlanner.addGiftOrder(MENU_GIFT, CHAMPAGNE, 1);

        decemberBadgeEvent.apply(eventPlanner);
        final Badge badge = eventPlanner.getBadge();

        assertThat(badge).isEqualTo(DecemberBadge.SANTA);
    }
}
