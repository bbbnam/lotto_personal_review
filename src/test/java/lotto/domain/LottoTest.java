package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트 - 자동 생성")
    void selectLottoNumbers_auto() {
        NumberSelector numberSelector = new Auto();

        Lotto lotto = new Lotto(numberSelector);

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 생성 테스트 - 수동 생성")
    void selectLottoNumbers_manual() {
        NumberSelector numberSelector = new Manual("1,2,3,4,5,6");

        Lotto lotto = new Lotto(numberSelector);
        List<LottoNumber> numbers = lotto.getNumbers();

        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(numbers.get(0)).isEqualTo(new LottoNumber(1));
    }
}
