package christmas.model.event;

import christmas.model.ClientOrders;
import christmas.model.calendar.DecemberDate;

public interface DiscountEvent extends Event {
    int apply(final DecemberDate date, final ClientOrders orderMenu);
}