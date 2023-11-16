package christmas.dto;

import static christmas.message.OutputMessage.VISIT_PLAN_DATE_FORMAT;

import christmas.model.calendar.DecemberDate;

public record VisitPlanDateDto(int date) {
    public static VisitPlanDateDto of(final DecemberDate decemberDate) {
        return new VisitPlanDateDto(decemberDate.getDate());
    }

    @Override
    public String toString() {
        return String.format(VISIT_PLAN_DATE_FORMAT.getMessage(), date);
    }
}
