package christmas.config;

import christmas.controller.EventPlannerController;
import christmas.model.event.ChampagneGiftEvent;
import christmas.model.event.ChristmasDiscountEvent;
import christmas.model.event.DecemberBadgeEvent;
import christmas.model.event.EventManager;
import christmas.model.event.SpecialDiscountEvent;
import christmas.model.event.WeekDayDiscountEvent;
import christmas.model.event.WeekendDiscountEvent;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {
    public EventPlannerController eventPlannerController() {
        return new EventPlannerController(eventManager(), inputView(), outputView());
    }

    public EventManager eventManager() {
        return new EventManager()
                .addEvent(new ChristmasDiscountEvent())
                .addEvent(new WeekDayDiscountEvent())
                .addEvent(new WeekendDiscountEvent())
                .addEvent(new SpecialDiscountEvent())
                .addEvent(new ChampagneGiftEvent())
                .addEvent(new DecemberBadgeEvent());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
