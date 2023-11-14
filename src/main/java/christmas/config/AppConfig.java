package christmas.config;

import christmas.controller.EventPlannerController;
import christmas.model.event.applicable.ChampagneGiftEvent;
import christmas.model.event.applicable.ChristmasDiscountEvent;
import christmas.model.event.applicable.DecemberBadgeEvent;
import christmas.model.event.EventManager;
import christmas.model.event.applicable.SpecialDiscountEvent;
import christmas.model.event.applicable.WeekDayDiscountEvent;
import christmas.model.event.applicable.WeekendDiscountEvent;
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
                .addEvent(new DecemberBadgeEvent())
                .addEvent(new ChampagneGiftEvent())
                .setUp();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
