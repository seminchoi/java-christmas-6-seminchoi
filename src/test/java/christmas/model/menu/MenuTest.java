package christmas.model.menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class MenuTest {

    @ParameterizedTest
    @DisplayName("메뉴 이름을 전달하여 메뉴 상수를 반환받는다.")
    @ValueSource(strings = {"양송이수프", "티본스테이크", "초코케이크", "제로콜라"})
    void given_menuName_when_getMenuByName_then_Menu(final String menuName) {
        final Menu menu = Menu.getMenuByName(menuName);
        final String actualMenuName = menu.getName();

        assertThat(actualMenuName).isEqualTo(menuName);
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 메뉴 이름을 전달하면 예외가 발생한다.")
    @ValueSource(strings = {"양송이스프", "exam", "123"})
    void given_invalidMenuName_when_getMenuByName_then_throwException(final String menuName) {
        assertThatThrownBy(() -> Menu.getMenuByName(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
