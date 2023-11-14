package christmas.dto;

import static christmas.message.OutputMessage.BENEFIT_FORMAT;
import static christmas.message.OutputMessage.NOTHING;
import static christmas.message.TitleMessage.BENEFITS_TITLE;

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
        final String title = BENEFITS_TITLE.getMessage();
        stringBuilder.append(title);

        if(benefits.isEmpty()) {
            stringBuilder.append(NOTHING.getMessage());
            return stringBuilder.toString();
        }
        addContent(stringBuilder);

        return stringBuilder.toString();
    }

    private void addContent(final StringBuilder stringBuilder) {
        for (String event : benefits.keySet()) {
            final int benefitAmount = benefits.get(event);
            stringBuilder.append(makeBenefitDetail(event, benefitAmount));
        }
    }

    private String makeBenefitDetail(final String event, final int benefitAmount) {
        return String.format(BENEFIT_FORMAT.getMessage(), event, benefitAmount);
    }
}
