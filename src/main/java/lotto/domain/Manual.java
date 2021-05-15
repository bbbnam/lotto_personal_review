package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Manual implements NumberSelector {

    private final List<LottoNumber> lottoNumbers;

    public Manual(String lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = convertToList(lottoNumbers);
    }

    private void validateLottoNumbers(String lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException("빈값이 올 수 없습니다.");
        }
    }

    private List<LottoNumber> convertToList(String lottoNumbers) {
        String[] splited = lottoNumbers.split(",");
        return Stream.of(splited)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> selectNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
