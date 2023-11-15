package christmas.model.menu;

import static christmas.message.ErrorMessage.INVALID_ORDERS;
import static christmas.model.menu.MenuCategory.APPETIZER;
import static christmas.model.menu.MenuCategory.MAIN;
import static christmas.model.menu.MenuCategory.DESSERT;
import static christmas.model.menu.MenuCategory.BEVERAGE;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Menu {
    YANGSONG_SOUP("양송이수프", APPETIZER, 6_000),
    TAPAS("타파스", APPETIZER, 5_500),
    CAESAR_SALAD("시저샐러드", APPETIZER, 8_000),

    T_BONE_STEAK("티본스테이크", MAIN, 55_000),
    BBQ_RIB("바비큐립", MAIN, 54_000),
    SEAFOOD_PASTA("해산물파스타", MAIN, 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", MAIN, 25_000),

    CHOCO_CAKE("초코케이크", DESSERT, 15_000),
    ICE_CREAM("아이스크림", DESSERT, 5_000),

    ZERO_COLA("제로콜라", BEVERAGE, 3_000),
    RED_WINE("레드와인", BEVERAGE, 60_000),
    CHAMPAGNE("샴페인", BEVERAGE, 25_000),
    ;

    private static final Map<String, Menu> nameToMenu = Stream.of(values())
            .collect(Collectors.toUnmodifiableMap(Menu::getName, Function.identity()));

    private final String name;
    private final MenuCategory category;
    private final int price;

    Menu(final String name, final MenuCategory category, final int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static Menu getMenuByName(final String name) {
        if (nameToMenu.containsKey(name)) {
            return nameToMenu.get(name);
        }
        throw new IllegalArgumentException(INVALID_ORDERS.getMessage());
    }

    public int calculatePriceByPurchaseCount(final int purchaseCount) {
        return price * purchaseCount;
    }

    public boolean isIndividualOrderPossible() {
        return category.isIndividualOrderPossible();
    }

    public String getName() {
        return name;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}
