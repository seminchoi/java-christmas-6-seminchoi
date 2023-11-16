package christmas.model.event.applicable;

import static christmas.model.menu.Menu.CHAMPAGNE;
import static christmas.model.event.EventKind.MENU_GIFT;

import christmas.model.event.EventKind;
import christmas.model.order.ClientOrders;
import christmas.model.planner.EventPlanner;
import christmas.model.menu.Menu;

public class ChampagneGiftEvent implements Event {
    private static final EventKind kind = MENU_GIFT;
    private static final int MIN_ORDER_AMOUNT_FOR_SATISFIED_CONDITION = 120_000;
    private static final Menu GIFT_MENU = CHAMPAGNE;
    private static final int GIFT_COUNT = 1;

    @Override
    public void apply(final EventPlanner eventPlanner) {
        final ClientOrders clientOrders = eventPlanner.getClientOrders();
        if(isSatisfiedEventConditions(clientOrders)) {
            eventPlanner.addGiftOrder(kind, GIFT_MENU, GIFT_COUNT);
        }
    }

    private boolean isSatisfiedEventConditions(final ClientOrders clientOrders) {
        return clientOrders.sumTotalAmount() >= MIN_ORDER_AMOUNT_FOR_SATISFIED_CONDITION;
    }


    @Override
    public EventKind getKind() {
        return kind;
    }
}
