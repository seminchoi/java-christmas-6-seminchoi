package christmas.controller;

import christmas.dto.EventPlannerDto;
import christmas.model.ClientOrders;
import christmas.model.EventPlanner;
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
        EventPlanner eventPlanner = createEventPlanner();
        eventManager.applyEvents(eventPlanner);

        EventPlannerDto eventPlannerDto = EventPlannerDto.of(eventPlanner);
        outputView.printEventPlanner(eventPlannerDto);
    }

    private EventPlanner createEventPlanner() {
        DecemberDate decemberDate = createDecemberDate();
        ClientOrders clientOrders = createClientOrders();
        return new EventPlanner(decemberDate, clientOrders);
    }

    private DecemberDate createDecemberDate() {
        while (true) {
            try {
                int date = inputView.readDate();
                return new DecemberDate(date);
            } catch (IllegalArgumentException causedClient) {
                outputView.printErrorMessage(causedClient);
            }
        }
    }

    private ClientOrders createClientOrders() {
        while (true) {
            try {
                Map<String, Integer> clientOrders = inputView.readOrders();
                return new ClientOrders(clientOrders);
            } catch (IllegalArgumentException causedClient) {
                outputView.printErrorMessage(causedClient);
            }
        }
    }
}
