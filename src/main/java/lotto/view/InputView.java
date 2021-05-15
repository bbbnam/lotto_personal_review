package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private final Scanner scanner;
    private static InputView inputView;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public long inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextLong();
    }

    public long inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLong();
    }

    public List<String> inputManualLottoNumbers(long manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        if (manualCount == 0) {
            return Collections.emptyList();
        }
        return Stream.generate(scanner::next)
                .limit(manualCount)
                .collect(Collectors.toList());
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public int inputBonusNumbers() {
        System.out.println("보너스 볼을 입력해 주세요");
        return scanner.nextInt();
    }
}
