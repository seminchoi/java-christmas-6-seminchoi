package christmas.model.event.badge;

import static christmas.model.event.EventKind.DECEMBER_BADGE;

import christmas.model.event.EventKind;

public enum DecemberBadge implements Badge {
    NOTHING("없음", 0),
    STAR("별", -5_000),
    TREE("트리", -10_000),
    SANTA("산타", -20_000),
    ;

    private static final EventKind eventKind = DECEMBER_BADGE;

    private final String description;
    private final int benefitAmountForReceiving;

    DecemberBadge(final String description, final int benefitAmountForReceiving) {
        this.description = description;
        this.benefitAmountForReceiving = benefitAmountForReceiving;
    }

    public static DecemberBadge findByBenefitAmount(final int benefitAmount) {
        DecemberBadge highestBadge = NOTHING;
        for (final DecemberBadge badge : DecemberBadge.values()) {
            if(isSatisfiedEventCondition(badge, benefitAmount)) {
                highestBadge = highest(highestBadge, badge);
            }
        }
        return highestBadge;
    }

    private static boolean isSatisfiedEventCondition(final DecemberBadge badge, final int benefitAmount) {
        return badge.benefitAmountForReceiving >= benefitAmount;
    }

    private static DecemberBadge highest(final DecemberBadge badge1, final DecemberBadge badge2) {
        if(badge1.benefitAmountForReceiving < badge2.benefitAmountForReceiving) {
            return badge1;
        }
        return badge2;
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