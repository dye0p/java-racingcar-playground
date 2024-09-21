package racingcar.model;

import java.util.List;
import racingcar.model.util.winnerstrategy.WinnerStrategy;

public class RacingJudge {

    private final Cars cars;
    private final WinnerStrategy winnerStrategy;

    protected RacingJudge(Cars cars, WinnerStrategy winnerStrategy) {
        this.cars = cars;
        this.winnerStrategy = winnerStrategy;
    }

    public List<String> findWinner() {
        return winnerStrategy.findWinnerCarNames(cars);
    }

    public static RacingJudge create(Cars cars, WinnerStrategy winnerStrategy) {
        return new RacingJudge(cars, winnerStrategy);
    }
}
