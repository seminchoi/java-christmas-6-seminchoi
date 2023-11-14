package christmas.model.order;

import static christmas.model.menu.Menu.CHAMPAGNE;
import static christmas.model.menu.Menu.CHRISTMAS_PASTA;
import static christmas.model.menu.Menu.TAPAS;
import static christmas.model.menu.Menu.YANGSONG_SOUP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.model.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.EnumMap;
import java.util.Map;

class OrdersTest {
    static class SimpleOrders extends Orders {
        public SimpleOrders(Map<Menu, Integer> orders) {
            this.orders.putAll(orders);
        }
    }

    @DisplayName("주문에 여러 개의 메뉴를 추가했을 때 특정 메뉴의 개수를 반환한다.")
    @Test
    void given_variousOrders_when_getCountBySpecificMenu_then_menuCount() {
        SimpleOrders simpleOrders = createDefaultSimpleOrders();

        int count = simpleOrders.getCountByMenu(YANGSONG_SOUP);

        assertThat(count).isEqualTo(10);
    }

    @DisplayName("주문의 가격을 계산한다.")
    @Test
    void given_orders_when_sumTotalAmount_then_totalAmount() {
        SimpleOrders simpleOrders = createDefaultSimpleOrders();

        int totalAmount = simpleOrders.sumTotalAmount();

        assertThat(totalAmount).isEqualTo(360_000);
    }

    @DisplayName("콜렉션 필드는 unmodifiable 콜렉션이다.")
    @Test
    void when_getOrders_then_unmodifiableCollection() {
        SimpleOrders simpleOrders = createDefaultSimpleOrders();

        Map<Menu, Integer> orders = simpleOrders.getOrders();

        assertThatThrownBy(() -> orders.put(TAPAS, 10))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    private SimpleOrders createDefaultSimpleOrders() {
        Map<Menu, Integer> orders = new EnumMap<>(Menu.class);

        orders.put(YANGSONG_SOUP, 10);
        orders.put(CHRISTMAS_PASTA, 8);
        orders.put(CHAMPAGNE, 4);

       return new SimpleOrders(orders);
    }
}
