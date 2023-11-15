package christmas.model.menu;

public enum MenuCategory {
    APPETIZER(true),
    MAIN(true),
    DESSERT(true),
    BEVERAGE(false);

    private final boolean canOrderIndividually;

    MenuCategory(boolean canOrderIndividually) {
        this.canOrderIndividually = canOrderIndividually;
    }

    public boolean isIndividualOrderPossible() {
        return canOrderIndividually;
    }
}
