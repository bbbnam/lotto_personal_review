package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTypeTest {

    @Test
    @DisplayName("매치 카운트(일치번호 갯수)에 따라 등수 구하는 로직 테스트")
    void matchPrize() {
        int matchCount = 6;

        WinningType winningType = WinningType.findType(matchCount, false);

        assertThat(winningType).isEqualTo(WinningType.FIRST);
    }

    @Test
    @DisplayName("2등 구하는 로직(보너스볼) 테스트")
    void matchPrize_for_Second() {
        int matchCount = 5;

        WinningType winningType = WinningType.findType(matchCount, true);

        assertThat(winningType).isEqualTo(WinningType.SECOND);
    }

    @Test
    @DisplayName("3등 구하는 로직(보너스볼 x) 테스트")
    void matchPrize_for_Third() {
        int matchCount = 5;

        WinningType winningType = WinningType.findType(matchCount, false);

        assertThat(winningType).isEqualTo(WinningType.THIRD);
    }
}
