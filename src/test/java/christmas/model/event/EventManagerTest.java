package christmas.model.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.config.AppConfig;
import christmas.model.planner.EventPlanner;
import christmas.util.EventUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class EventManagerTest {
    private EventManager eventManager;

    @BeforeEach
    void init() {
        final AppConfig appConfig = new AppConfig();
        eventManager = appConfig.eventManager();
    }

    @DisplayName("주문 금액이 10,000원 미만이면 이벤트를 적용하지 않는다.")
    @Test
    void given_orderAmountUnderCondition_when_applyEvents_then_isNotApply() {
        EventPlanner eventPlanner = EventUtil.createEventPlannerByDate(1, createOrders());
        eventManager.applyEvents(eventPlanner);

        final int benefitAmount = eventPlanner.getTotalBenefitAmount();

        assertThat(benefitAmount).isZero();
    }

    private Map<String, Integer> createOrders() {
        final Map<String, Integer> orders = new HashMap<>();
        orders.put("시저샐러드", 1);

        return orders;
    }
}
