package christmas.model;

import java.util.Optional;

public enum DecemberBadge implements Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    ;

    private final String description;
    private final int minBenefitAmountForReceiving;

    DecemberBadge(String description, int minBenefitAmountForReceiving) {
        this.description = description;
        this.minBenefitAmountForReceiving = minBenefitAmountForReceiving;
    }

    public static Optional<Badge> findByBenefitAmount(final int benefitAmount) {
        for (DecemberBadge badge : DecemberBadge.values()) {
            if(isSatisfiedEventCondition(badge, benefitAmount)) {
                return Optional.of(badge);
            }
        }
        return Optional.empty();
    }

    private static boolean isSatisfiedEventCondition(final DecemberBadge badge, final int benefitAmount) {
        return badge.minBenefitAmountForReceiving <= benefitAmount;
    }

    @Override
    public String getDescription() {
        return description;
    }
}