package christmas.view;

import static christmas.message.ErrorMessage.INVALID_DATE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        return parseIntOrThrow(input);
    }

    private int parseIntOrThrow(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }
}