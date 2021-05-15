package lotto.view;

import lotto.domain.Result;
import lotto.domain.Lotto;
import lotto.domain.WinningResults;
import lotto.domain.WinningType;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static OutputView outputView;

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printResult(Result result) {
        List<Lotto> lottos = result.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        System.out.println(
                lottos.stream()
                        .map(Lotto::toString)
                        .collect(Collectors.joining("\n")));
    }

    public void printWinningResult(long price, WinningResults winningResults) {
        System.out.println("당첨통계");
        System.out.println("--------");
        WinningType.getReverseValues()
                .stream()
                .map(type -> printWinninTypesDetail(winningResults, type))
                .forEach(System.out::println);
        System.out.println(String.format("총 수익률은 %.2f입니다.", winningResults.calculateProfitRate(price)));
    }

    private String printWinninTypesDetail(WinningResults winningResults, WinningType type) {
        if (type.equals(WinningType.SECOND)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개",
                    type.getMatchCount(), type.getPrize(), winningResults.count(type));
        }
        return String.format("%d개 일치 (%d원)- %d개",
                type.getMatchCount(), type.getPrize(), winningResults.count(type));
    }
}
