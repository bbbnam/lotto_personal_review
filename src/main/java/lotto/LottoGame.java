package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

//    private static Result buyLottosProcess(long price) {
//        long manualCount = inputView.inputManualLottoCount();
//        List<String> manuals = inputView.inputManualLottoNumbers(manualCount);
//        LottoShop lottoShop = new LottoShop(price, manuals);
//        List<Lotto> lottos = lottoShop.buyLottos();
//
//        return new Result(lottos);
//    }
//
//    private static WinningResults showWinningResultsProcess(Result result) {
//        String numbers = inputView.inputWinningNumbers();
//        int bonus = inputView.inputBonusNumbers();
//
//        Lotto winningLotto = new Lotto(new Manual(numbers));
//        LottoNumber bonusNumber = new LottoNumber(bonus);
//        return result.matchWinningType(winningLotto, bonusNumber);
//    }

    public static void main(String[] args) {
//        long price = inputView.inputPrice();
//        Result result = buyLottosProcess(price);
//        outputView.printResult(result);
//
//        WinningResults winningResults = showWinningResultsProcess(result);
//        outputView.printWinningResult(price, winningResults);
    }
}
