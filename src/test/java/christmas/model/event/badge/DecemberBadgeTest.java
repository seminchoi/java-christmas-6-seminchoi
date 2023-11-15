package christmas.model.event.badge;

import static christmas.model.event.badge.DecemberBadge.NOTHING;
import static christmas.model.event.badge.DecemberBadge.SANTA;
import static christmas.model.event.badge.DecemberBadge.STAR;
import static christmas.model.event.badge.DecemberBadge.TREE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecemberBadgeTest {
    @DisplayName("혜택 금액이 20,000원 이상이면 산타 배지를 받는다.")
    @Test
    void given_benefitAmount_when_findBadgeBy_then_santa() {
        DecemberBadge badge = given_benefitAmount_when_findByBenefitAmount(-20_000);

        assertThat(badge).isEqualTo(SANTA);
    }

    @DisplayName("혜택 금액이 10,000원 이상이면 트리 배지를 받는다.")
    @Test
    void given_benefitAmount_when_findBadgeBy_then_tree() {
        DecemberBadge badge = given_benefitAmount_when_findByBenefitAmount(-10_000);

        assertThat(badge).isEqualTo(TREE);
    }

    @DisplayName("혜택 금액이 5,000원 이상이면 별 배지를 받는다.")
    @Test
    void given_benefitAmount_when_findBadgeBy_then_star() {
        DecemberBadge badge = given_benefitAmount_when_findByBenefitAmount(-5_000);

        assertThat(badge).isEqualTo(STAR);
    }

    @DisplayName("혜택 금액이 5,000원 이하이면 배지를 받지 않는다.")
    @Test
    void given_benefitAmount_when_findBadgeBy_then_nothing() {
        DecemberBadge badge = given_benefitAmount_when_findByBenefitAmount(-4_999);

        assertThat(badge).isEqualTo(NOTHING);
    }

    private DecemberBadge given_benefitAmount_when_findByBenefitAmount(final int benefitAmount) {
        return DecemberBadge.findByBenefitAmount(benefitAmount);
    }
}
