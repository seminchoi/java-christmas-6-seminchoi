package christmas.view;

import christmas.dto.EventPlannerDto;

public class OutputView {
    public void printEventPlanner(final EventPlannerDto eventPlannerDto) {
        System.out.println(eventPlannerDto);
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
