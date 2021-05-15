package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3", "1,2,3,4,5,5"})
    @DisplayName("로또 번호 유효성 검사")
    void validateLottoNumbers(String numbers) {
        Manual manual = new Manual(numbers);

        assertThatThrownBy(() -> new Lotto(manual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자값은 6개의 중복되지 않은 값만 선택 가능합니다.");
    }

    @Test
    @DisplayName("당첨번호를 입력받아 구매한 로또의 번호와 비교하여 당첨여부 테스트")
    void matchLotto() {
        Manual manual = new Manual("1,2,3,4,5,6");
        Lotto lotto = new Lotto(manual);

        List<LottoNumber> winningNumbers = new Manual("1,2,3,4,5,7").selectNumbers();

        assertThat(lotto.match(new Lotto(winningNumbers), new LottoNumber(3))).isEqualTo(WinningType.SECOND);
    }
}
