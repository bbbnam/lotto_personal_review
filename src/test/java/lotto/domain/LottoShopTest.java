package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @Test
    @DisplayName("구입금액에 맞는 로또를 발급한다(구매한다)")
    void buyLotto() {
        long price = 3000L;

        LottoShop lottoShop = new LottoShop(price);

        Assertions.assertThat(lottoShop.buyLottos()).hasSize(3);
    }
}
