package christmas.model.event;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class BenefitResult {
    private final Map<EventKind, Integer> result = new EnumMap<>(EventKind.class);

    public void addResult(EventKind eventKind, int discountAmount) {
        result.put(eventKind, discountAmount);
    }

    public int sumTotalBenefitAmount() {
        int totalBenefitAmount = 0;
        for (Integer benefitAmount : result.values()) {
            totalBenefitAmount += benefitAmount;
        }
        return totalBenefitAmount;
    }

    public Map<EventKind, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
