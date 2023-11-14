package christmas.model.order;

import static christmas.constant.TestConstants.INVALID_ORDER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class ClientOrdersTest {

    @DisplayName("주문의 메뉴 총 개수가 1개 이하면 예외가 발생한다.")
    @Test
    void given_emptyOrders_when_constructor_then_throwException() {
        Map<String, Integer> orders = new HashMap<>();

        assertThatThrownBy(() -> new ClientOrders(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER_ERROR_MESSAGE);
    }

    @DisplayName("주문의 메뉴 총 개수가 20개 이상이면 예외가 발생한다.")
    @Test
    void given_overTotalCount_when_constructor_then_throwException() {
        Map<String, Integer> orders = new HashMap<>();
        orders.put("양송이수프", 21);

        assertThatThrownBy(() -> new ClientOrders(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER_ERROR_MESSAGE);
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    void given_onlyBeverageOrders_when_constructor_then_throwException() {
        Map<String, Integer> orders = new HashMap<>();
        orders.put("제로콜라", 1);

        assertThatThrownBy(() -> new ClientOrders(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER_ERROR_MESSAGE);
    }
}
