package christmas.view;

import static christmas.message.ErrorMessage.INVALID_DATE;
import static christmas.message.ErrorMessage.INVALID_ORDERS;
import static christmas.message.InputMessage.*;

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
        System.out.println(VISIT_PLAN_DATE.getMessage());
        final String input = Console.readLine();
        return parseIntOrThrow(input, INVALID_DATE);
    }

    public Map<String, Integer> readOrders() {
        System.out.println(ORDERS.getMessage());
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
            String menu = iterator.next().trim();
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