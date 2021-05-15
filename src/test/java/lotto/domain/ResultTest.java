package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ResultTest {

    @Test
    @DisplayName("등수 결정된 결과값 정상적으로 리턴하는지 테스트")
    void matchWinningType() {
        Lotto lotto1 = new Lotto(new Manual("1,2,3,4,5,6"));
        Lotto lotto2 = new Lotto(new Manual("1,2,3,4,5,8"));
        List<Lotto> myLottos = Arrays.asList(lotto1, lotto2);
        Result result = new Result(myLottos);

        Lotto winningLotto = new Lotto(new Manual("1,2,3,4,5,9"));
        LottoNumber bonus = new LottoNumber(6);

        WinningResults winningResults = result.matchWinningType(winningLotto, bonus);

        Assertions.assertThat(winningResults.getResults()).contains(WinningType.SECOND, WinningType.THIRD);
    }
}
