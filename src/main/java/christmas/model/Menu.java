package christmas.model;

public enum Menu {
    YANGSONG_SOUP("양송이수프", MenuCategory.APPETIZER, 6_000),
    TAPAS("타파스", MenuCategory.APPETIZER, 5_500),
    CAESAR_SALAD("시저샐러드", MenuCategory.APPETIZER, 8_000),

    T_BONE_STEAK("티본스테이크", MenuCategory.MAIN, 55_000),
    BBQ_RIB("바비큐립", MenuCategory.MAIN, 54_000),
    SEAFOOD_PASTA("해산물파스타", MenuCategory.MAIN, 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", MenuCategory.MAIN, 25_000),

    CHOCO_CAKE("초코케이크", MenuCategory.DESSERT, 15_000),
    ICE_CREAM("아이스크림", MenuCategory.DESSERT, 5_000),

    ZERO_COLA("제로콜라", MenuCategory.BEVERAGE, 3_000),
    RED_WINE("레드와인", MenuCategory.BEVERAGE, 60_000),
    CHAMPAGNE("샴페인", MenuCategory.BEVERAGE, 25_000);

    private final String name;
    private final MenuCategory category;
    private final int price;

    Menu(String name, MenuCategory category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
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
