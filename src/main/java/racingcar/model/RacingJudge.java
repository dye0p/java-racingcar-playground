package racingcar.model;

import java.util.List;
import racingcar.model.util.winnerstrategy.WinnerStrategy;

public class RacingJudge {

    private final Cars cars;
    private final WinnerStrategy winnerStrategy;

    public RacingJudge(Cars cars, WinnerStrategy winnerStrategy) {
        this.cars = cars;
        this.winnerStrategy = winnerStrategy;
    }

    //가장 전진을 많이 한 자동차를 찾아냄
    public List<String> findWinner() {
        return winnerStrategy.findWinnerCarNames(cars);
    }
}
