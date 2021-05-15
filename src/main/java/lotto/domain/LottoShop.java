package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoShop {
    private static final long LOTTO_PRICE = 1000L;

    private final long inputPrice;
    private final List<String> manuals;

    public LottoShop(long inputPrice, List<String> manuals) {
        validatePrice(inputPrice);
        this.inputPrice = inputPrice;
        this.manuals = manuals;
    }

    private void validatePrice(long inputPrice) {
        if (inputPrice < 0) {
            throw new IllegalArgumentException("투입금액은 음수가 될 수 없습니다.");
        }
    }

    public List<Lotto> buyLottos() {
        long lottoCount = inputPrice / LOTTO_PRICE - manuals.size();
        List<Lotto> lottos = generateAuto(lottoCount);
        List<Lotto> manualLottos = generateManual();
        lottos.addAll(manualLottos);
        return lottos;
    }

    private List<Lotto> generateAuto(long lottoCount) {
        return Stream.generate(() -> new Lotto(new Auto()))
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private List<Lotto> generateManual() {
        return manuals.stream()
                .map(numbers -> new Lotto(new Manual(numbers)))
                .collect(Collectors.toList());
    }
}
