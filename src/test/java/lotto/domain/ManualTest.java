package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualTest {

    @Test
    @DisplayName("수동으로 숫자 생성 테스트 -정상일때")
    void selectNumbers() {
        Manual manual = new Manual("1,2,3,4,5,6");

        List<LottoNumber> lottoNumbers = manual.selectNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("수동으로 숫자 생성 테스트 - 빈값 또는 null 입력시 예외발생")
    void selectNumbers_exception(String numbers) {
        assertThatThrownBy(() -> new Manual(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈값이 올 수 없습니다.");
    }
}
