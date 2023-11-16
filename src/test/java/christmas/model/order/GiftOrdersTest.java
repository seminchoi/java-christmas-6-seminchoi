package christmas.model.order;

import static christmas.model.menu.Menu.CHAMPAGNE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

class GiftOrdersTest {

    @DisplayName("증정 주문을 추가한다.")
    @Test
    void given_order_when_addOrder_then_addedOrder() {
        final GiftOrders giftOrders = new GiftOrders();
        final Menu menu = CHAMPAGNE;
        final int count = 1;

        giftOrders.addOrder(menu, count);
        final Map<Menu, Integer> orders = giftOrders.getOrders();
        final int actualCount = orders.get(menu);

        assertThat(actualCount).isEqualTo(1);
    }
}
