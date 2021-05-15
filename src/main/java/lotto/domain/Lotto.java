package lotto.domain;

import java.util.ArrayList;
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
        if (set.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("숫자값은 중복 선택이 불가합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
