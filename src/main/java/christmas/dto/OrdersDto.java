package christmas.dto;

import static christmas.message.OutputMessage.ORDER_FORMAT;

import christmas.model.menu.Menu;
import christmas.model.order.Orders;
import java.util.LinkedHashMap;
import java.util.Map;

public record OrdersDto(Map<String, Integer> orders) {
    public static OrdersDto of(final Orders orders) {
        final Map<Menu, Integer> menuToCount = orders.getOrders();

        final Map<String, Integer> convertedOrders = menuToCount.entrySet()
                .stream()
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey().getName(), entry.getValue()),
                        Map::putAll
                );

        return new OrdersDto(convertedOrders);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (String menu : orders.keySet()) {
            final int count = orders.get(menu);
            stringBuilder.append(makeOrderDetail(menu, count));
        }

        return stringBuilder.toString();
    }

    private String makeOrderDetail(final String menu, final int count) {
        return String.format(ORDER_FORMAT.getMessage(), menu, count);
    }
}
