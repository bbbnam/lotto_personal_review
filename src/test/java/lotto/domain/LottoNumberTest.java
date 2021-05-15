package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 33, 45})
    @DisplayName("로또 번호 유효성 검사 - 정상일때")
    void validateLottoNumbers(int inputNumber) {
        LottoNumber lottoNumber = new LottoNumber(inputNumber);

        assertThat(lottoNumber.getNumber()).isEqualTo(inputNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, Integer.MAX_VALUE})
    @DisplayName("로또 번호 유효성 검사 - 범위를 벗어났을때 예외발생")
    void validateLottoNumbers_exception(int inputNumber) {
        assertThatThrownBy(() -> new LottoNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자값의 범위는 1~45 입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "5", "33", "45"})
    @DisplayName("로또 번호 유효성 검사 - 문자로 입력시 정상일때")
    void validateLottoNumbers_byString(String inputNumber) {
        LottoNumber lottoNumber = LottoNumber.valueOf(inputNumber);

        assertThat(lottoNumber.getNumber()).isEqualTo(Integer.parseInt(inputNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "46", "&&", "%"})
    @DisplayName("로또 번호 유효성 검사 - 문자로 입력시 비정상 입력시 예외발생")
    void validateLottoNumbers_byString_exception(String inputNumber) {
        assertThatThrownBy(() -> LottoNumber.valueOf(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
