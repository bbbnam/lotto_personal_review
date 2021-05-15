package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @Test
    @DisplayName("구입금액에 맞는 로또를 발급한다(구매한다) - 전체 자동 구매")
    void buyLotto_auto() {
        long price = 3000L;

        LottoShop lottoShop = new LottoShop(price, Collections.emptyList());

        assertThat(lottoShop.buyLottos()).hasSize(3);
    }

    @Test
    @DisplayName("구입금액에 맞는 로또를 발급한다(구매한다) - 자동 구매 외에 수동구매 추가")
    void buyLotto_manual() {
        long price = 5000L;
        String manualNumbers1 = "1,2,3,4,5,6";
        String manualNumbers2 = "2,3,4,5,6,7";
        Lotto manual1 = new Lotto(new Manual(manualNumbers1));
        Lotto manual2 = new Lotto(new Manual(manualNumbers2));

        LottoShop lottoShop = new LottoShop(price, Arrays.asList(manualNumbers1, manualNumbers2));

        List<Lotto> lottos = lottoShop.buyLottos();

        assertThat(lottos).hasSize(5);
        assertThat(lottos).contains(manual1, manual2);
    }
}
