package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class WinningResultsTest {

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfitRate() {
        long inputPrice = 14000L;
        Map<WinningType, Integer> winnings = new HashMap<>();
        winnings.put(WinningType.FIFTH, 1);

        WinningResults winningResults = new WinningResults(winnings);

        assertThat(winningResults.calculateProfitRate(inputPrice)).isEqualTo(0.35);
    }
}
