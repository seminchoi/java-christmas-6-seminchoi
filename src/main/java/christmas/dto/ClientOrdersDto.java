package christmas.dto;

import static christmas.message.OutputMessage.NOTHING;
import static christmas.message.OutputMessage.ORDER_FORMAT;
import static christmas.message.TitleMessage.CLIENT_ORDER_MENU_TITLE;

import christmas.model.menu.Menu;
import christmas.model.order.Orders;
import java.util.LinkedHashMap;
import java.util.Map;

public record ClientOrdersDto(Map<String, Integer> orders) {
    public static ClientOrdersDto of(final Orders orders) {
        final Map<Menu, Integer> menuToCount = orders.getOrders();

        final Map<String, Integer> convertedOrders = menuToCount.entrySet()
                .stream()
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey().getName(), entry.getValue()),
                        Map::putAll
                );

        return new ClientOrdersDto(convertedOrders);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        final String title = CLIENT_ORDER_MENU_TITLE.getMessage();
        stringBuilder.append(title);

        if(orders.isEmpty()) {
            stringBuilder.append(NOTHING.getMessage());
            return stringBuilder.toString();
        }
        addContent(stringBuilder);

        return stringBuilder.toString();
    }

    private void addContent(final StringBuilder stringBuilder) {
        for (String menu : orders.keySet()) {
            final int count = orders.get(menu);
            stringBuilder.append(makeOrderDetail(menu, count));
        }
    }

    private String makeOrderDetail(final String menu, final int count) {
        return String.format(ORDER_FORMAT.getMessage(), menu, count);
    }
}
