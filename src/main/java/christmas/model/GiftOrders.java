package christmas.model;

public class GiftOrders extends Orders {
    public int sumTotalGiftMenusPrice() {
        int totalGiftMenusPrice = 0;
        for (Menu menu : orders.keySet()) {
            final int giftCount = orders.get(menu);
            totalGiftMenusPrice += menu.getPrice() * giftCount;
        }
        return totalGiftMenusPrice;
    }
}