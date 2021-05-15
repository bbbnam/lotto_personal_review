package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoShop {
    private static final long LOTTO_PRICE = 1000L;

    private final long inputPrice;

    public LottoShop(long inputPrice) {
        validatePrice(inputPrice);
        this.inputPrice = inputPrice;
    }

    private void validatePrice(long inputPrice) {
        if (inputPrice < 0) {
            throw new IllegalArgumentException("투입금액은 음수가 될 수 없습니다.");
        }
    }

    public List<Lotto> buyLottos() {
        long lottoCount = inputPrice / LOTTO_PRICE;
        List<Lotto> lottos = Stream.generate(() -> new Lotto(new Auto()))
                .limit(lottoCount)
                .collect(Collectors.toList());
        return lottos;
    }
}
