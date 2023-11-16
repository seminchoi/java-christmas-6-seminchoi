package christmas.controller;

import christmas.dto.EventPlannerDto;
import christmas.model.order.ClientOrders;
import christmas.model.planner.EventPlanner;
import christmas.model.calendar.DecemberDate;
import christmas.model.event.EventManager;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventPlannerController {
    private final EventManager eventManager;
    private final InputView inputView;
    private final OutputView outputView;

    public EventPlannerController(EventManager eventManager, InputView inputView, OutputView outputView) {
        this.eventManager = eventManager;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final EventPlanner eventPlanner = createEventPlanner();
        eventManager.applyEvents(eventPlanner);

        final EventPlannerDto eventPlannerDto = EventPlannerDto.of(eventPlanner);
        outputView.printEventPlanner(eventPlannerDto);
    }

    private EventPlanner createEventPlanner() {
        final DecemberDate decemberDate = createDecemberDate();
        final ClientOrders clientOrders = createClientOrders();
        inputView.finishInput();
        return new EventPlanner(decemberDate, clientOrders);
    }

    private DecemberDate createDecemberDate() {
        while (true) {
            try {
                final int date = inputView.readDate();
                return new DecemberDate(date);
            } catch (IllegalArgumentException causedClient) {
                outputView.printErrorMessage(causedClient);
            }
        }
    }

    private ClientOrders createClientOrders() {
        while (true) {
            try {
                final Map<String, Integer> clientOrders = inputView.readOrders();
                return new ClientOrders(clientOrders);
            } catch (IllegalArgumentException causedClient) {
                outputView.printErrorMessage(causedClient);
            }
        }
    }
}
