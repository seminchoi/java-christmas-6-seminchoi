package christmas.model.event.result;

import static christmas.model.event.EventKind.CHRISTMAS_DISCOUNT;
import static christmas.model.event.EventKind.WEEKDAY_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.event.EventKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class BenefitsTest {
    private final Benefits benefits = new Benefits();

    @DisplayName("할인이 0원 이라면 혜택 목록에 추가하지 않는다.")
    @Test
    void given_discountAmountZero_when_addResult_then_isNotAdded() {
        final EventKind eventKind = WEEKDAY_DISCOUNT;

        benefits.addResult(eventKind, 0);
        final Map<EventKind, Integer> result = benefits.getResult();
        final boolean isAdded = result.containsKey(eventKind);

        assertThat(isAdded).isFalse();
    }

    @DisplayName("할인 금액의 총합을 계산한다.")
    @Test
    void given_addResult_when_sumTotalBenefitAmount_then_correctAmount() {
        benefits.addResult(WEEKDAY_DISCOUNT, -2_023);
        benefits.addResult(CHRISTMAS_DISCOUNT, -1_000);

        final int totalBenefitAmount = benefits.sumTotalBenefitAmount();

        assertThat(totalBenefitAmount).isEqualTo(-3_023);
    }
}
