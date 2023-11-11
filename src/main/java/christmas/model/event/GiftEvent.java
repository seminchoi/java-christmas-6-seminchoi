package christmas.model.event;

import christmas.model.ClientOrders;
import christmas.model.GiftOrders;

public interface GiftEvent extends Event {
    GiftOrders apply(GiftOrders giftOrders, ClientOrders clientOrders);
}
