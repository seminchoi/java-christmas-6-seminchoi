package christmas.model.event.badge;

import static christmas.model.event.EventKind.DECEMBER_BADGE;

import christmas.model.event.EventKind;

public enum DecemberBadge implements Badge {
    SANTA("산타", -20_000),
    TREE("트리", -10_000),
    STAR("별", -5_000),
    NOTHING("없음", 0)
    ;

    private static final EventKind eventKind = DECEMBER_BADGE;
    private final String description;
    private final int minBenefitAmountForReceiving;

    DecemberBadge(final String description, final int minBenefitAmountForReceiving) {
        this.description = description;
        this.minBenefitAmountForReceiving = minBenefitAmountForReceiving;
    }

    public static DecemberBadge findByBenefitAmount(final int benefitAmount) {
        for (DecemberBadge badge : DecemberBadge.values()) {
            if(isSatisfiedEventCondition(badge, benefitAmount)) {
                return badge;
            }
        }
        return NOTHING;
    }

    private static boolean isSatisfiedEventCondition(final DecemberBadge badge, final int benefitAmount) {
        return badge.minBenefitAmountForReceiving >= benefitAmount;
    }

    @Override
    public EventKind getEventKind() {
        return eventKind;
    }

    @Override
    public String getDescription() {
        return description;
    }
}