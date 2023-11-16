package christmas.model.event.result;

import christmas.model.event.EventKind;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class Benefits {
    private final Map<EventKind, Integer> result = new EnumMap<>(EventKind.class);

    public void addResult(final EventKind eventKind, final int discountAmount) {
        if(isDiscounted(discountAmount)) {
            result.put(eventKind, discountAmount);
        }
    }

    private boolean isDiscounted(final int discountAmount) {
        return discountAmount != 0;
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
