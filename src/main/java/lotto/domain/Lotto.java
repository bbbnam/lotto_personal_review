package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateNumbersSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(NumberSelector numberSelector) {
        this(numberSelector.selectNumbers());
    }

    private void validateNumbersSize(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        if (set.size() < 6) {
            throw new IllegalArgumentException("숫자값은 6개의 중복되지 않은 값만 선택 가능합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
