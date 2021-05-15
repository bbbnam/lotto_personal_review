package lotto.domain;

import java.util.*;

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

    public WinningType match(Lotto winningLotto, LottoNumber bonus) {
        List<LottoNumber> winningNumbers = new ArrayList<>(winningLotto.lottoNumbers);
        winningNumbers.retainAll(this.lottoNumbers);
        boolean matchBonus = isMatcheBonus(bonus);
        return WinningType.findType(winningNumbers.size(), matchBonus);
    }

    private boolean isMatcheBonus(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
