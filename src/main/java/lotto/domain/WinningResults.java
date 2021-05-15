package lotto.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningResults {
    private final Map<WinningType, Integer> results;

    public WinningResults(Map<WinningType, Integer> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public int count(WinningType type) {
        return results.getOrDefault(type, 0);
    }

    public double calculateProfitRate(long inputPrice) {
        Set<WinningType> winningTypes = results.keySet();
        long totalPrize = 0;
        for (WinningType type : winningTypes) {
            totalPrize += type.getPrize();
        }
        return divideByPrice(inputPrice, totalPrize);
    }

    private double divideByPrice(long inputPrice, long totalPrize) {
        BigDecimal divided = new BigDecimal(String.valueOf(totalPrize))
                .divide(new BigDecimal(String.valueOf(inputPrice)), 2, BigDecimal.ROUND_DOWN);
        return divided.doubleValue();
    }

    public List<WinningType> getResults() {
        Set<WinningType> winningTypes = results.keySet();
        return winningTypes.stream()
                .collect(Collectors.toList());
    }
}
