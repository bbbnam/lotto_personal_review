package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Result {

    private final List<Lotto> lottos;

    public Result(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public WinningResults matchWinningType(Lotto winningLotto, LottoNumber bonus) {
        Map<WinningType, Integer> map = new HashMap<>();
        List<WinningType> matches = matches(winningLotto, bonus);
        for (WinningType type : matches) {
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        return new WinningResults(map);
    }

    private List<WinningType> matches(Lotto winningLotto, LottoNumber bonus) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningLotto, bonus))
                .filter(type -> type != WinningType.NOTHING)
                .collect(Collectors.toList());
    }
}
