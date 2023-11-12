package christmas.model.event;

import static christmas.model.Menu.CHAMPAGNE;
import static christmas.model.event.EventKind.CHAMPAGNE_GIFT;

import christmas.model.ClientOrders;
import christmas.model.GiftOrders;
import christmas.model.Menu;

public class ChampagneGiftEvent implements GiftEvent {
    private static final EventKind type = CHAMPAGNE_GIFT;
    private static final int MIN_ORDER_AMOUNT_FOR_SATISFIED_CONDITION = 120_000;
    private static final Menu GIFT_MENU = CHAMPAGNE;
    private static final int GIFT_COUNT = 1;

    @Override
    public GiftOrders apply(GiftOrders giftOrders, ClientOrders clientOrders) {
        if(isSatisfiedEventConditions(clientOrders)) {
            clientOrders.addOrder(GIFT_MENU, GIFT_COUNT);
        }
        return giftOrders;
    }

    private boolean isSatisfiedEventConditions(ClientOrders clientOrders) {
        return clientOrders.sumTotalAmount() >= MIN_ORDER_AMOUNT_FOR_SATISFIED_CONDITION;
    }

    @Override
    public EventKind getType() {
        return type;
    }
}
