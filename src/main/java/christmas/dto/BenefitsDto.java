package christmas.dto;

import static christmas.message.OutputMessage.BENEFIT_FORMAT;

import christmas.model.event.EventKind;
import christmas.model.event.result.Benefits;
import java.util.LinkedHashMap;
import java.util.Map;

public record BenefitsDto(Map<String, Integer> benefits) {
    public static BenefitsDto of(final Benefits benefits) {
        final Map<EventKind, Integer> eventToAmount = benefits.getResult();

        Map<String, Integer> convertedBenefits = eventToAmount.entrySet()
                .stream()
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey().getDescription(), entry.getValue()),
                        Map::putAll
                );

        return new BenefitsDto(convertedBenefits);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (String event : benefits.keySet()) {
            final int benefitAmount = benefits.get(event);
            stringBuilder.append(makeBenefitDetail(event, benefitAmount));
        }

        return stringBuilder.toString();
    }

    private String makeBenefitDetail(final String event, final int benefitAmount) {
        return String.format(BENEFIT_FORMAT.getMessage(), event, benefitAmount);
    }
}
