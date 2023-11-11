package christmas.model.event;

import christmas.model.ClientOrders;
import christmas.model.calendar.DecemberDate;

public interface DiscountEvent extends Event {
    void apply(final DiscountResult result, final DecemberDate decemberDate, final ClientOrders orderMenu);
}