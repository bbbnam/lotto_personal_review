package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumberSelector {
    List<LottoNumber> selectNumbers();
}
