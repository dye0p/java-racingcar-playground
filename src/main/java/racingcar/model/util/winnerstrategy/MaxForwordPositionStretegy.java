package racingcar.model.util.winnerstrategy;

import java.util.List;
import racingcar.model.Cars;

public class MaxForwordPositionStretegy implements WinnerStrategy {

    @Override
    public List<String> findWinnerCarNames(Cars cars) {
        int maxForwordPositionCount = cars.maxForwordPositionCount();
        return cars.compareCarPositions(maxForwordPositionCount);
    }
}
