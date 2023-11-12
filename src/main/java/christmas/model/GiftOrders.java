package christmas.model;

public class GiftOrders extends Orders {
    public int sumTotalGiftMenusPrice() {
        int totalGiftMenusPrice = 0;
        for (Menu menu : orderMenus.keySet()) {
            final int giftCount = orderMenus.get(menu);
            totalGiftMenusPrice += menu.getPrice() * giftCount;
        }
        return totalGiftMenusPrice;
    }
}