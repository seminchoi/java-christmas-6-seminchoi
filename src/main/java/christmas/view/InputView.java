package christmas.view;

import static christmas.message.ErrorMessage.INVALID_DATE;
import static christmas.message.ErrorMessage.INVALID_ORDERS;

import camp.nextstep.edu.missionutils.Console;
import christmas.message.ErrorMessage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        final String input = Console.readLine();
        return parseIntOrThrow(input, INVALID_DATE);
    }

    public Map<String, Integer> readOrders() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        final String input = Console.readLine();
        return parseOrders(input);
    }

    private Map<String, Integer> parseOrders(String input) {
        final Map<String, Integer> orders = new HashMap<>();
        final List<String> parsedInput = Arrays.asList(input.split("[-,]"));
        final Iterator<String> inputIterator = parsedInput.iterator();

        while (inputIterator.hasNext()) {
            addOrder(orders, inputIterator);
        }
        return orders;
    }

    private void addOrder(final Map<String, Integer> orders, final Iterator<String> iterator) {
        try {
            String menu = iterator.next();
            validateMenu(orders, menu);
            int amount = parseIntOrThrow(iterator.next(), INVALID_ORDERS);
            orders.put(menu, amount);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private void validateMenu(final Map<String, Integer> orders, final String menu) {
        if (orders.containsKey(menu)) {
            throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
        }
    }

    private int parseIntOrThrow(final String input, final ErrorMessage errorMessage) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}