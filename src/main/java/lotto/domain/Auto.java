package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Auto implements NumberSelector {

    private static final List<LottoNumber> cache;

    static {
        cache = IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> selectNumbers() {
        Collections.shuffle(cache);
        List<LottoNumber> lottoNumbers = cache.subList(0, 6);
        Collections.sort(lottoNumbers);
        return new ArrayList<>(lottoNumbers);
    }
}
