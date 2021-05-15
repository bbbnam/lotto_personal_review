package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTypeTest {

    @Test
    @DisplayName("매치 카운트(일치번호 갯수)에 따라 등수 구하는 로직 테스트")
    void matchPrize() {
        int matchCount = 6;

        WinningType winningType = WinningType.findType(matchCount);

        assertThat(winningType).isEqualTo(WinningType.FIRST);
    }
}
