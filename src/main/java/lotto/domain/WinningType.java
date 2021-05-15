package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningType {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NOTHING(0, 0);

    private final long prize;
    private final int matchCount;

    WinningType(long prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static WinningType findType(int matchCount) {
        return Stream.of(values())
                .filter(it -> it.matchCount == matchCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
