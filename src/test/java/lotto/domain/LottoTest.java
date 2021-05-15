package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 생성시 로또 번호 선택되는지 테스트 - 자동 생성")
    void selectLottoNumbers() {
        NumberSelector numberSelector = new Auto();

        Lotto lotto = new Lotto(numberSelector);

        assertThat(lotto.getNumbers()).hasSize(6);
    }
}
