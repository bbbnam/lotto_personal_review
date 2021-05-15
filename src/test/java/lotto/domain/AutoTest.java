package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoTest {

    @Test
    @DisplayName("자동으로 숫자 생성 테스트")
    void selectNumbers() {
        Auto auto = new Auto();

        List<LottoNumber> lottoNumbers = auto.selectNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }
}
