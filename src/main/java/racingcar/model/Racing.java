package racingcar.model;

import java.util.List;

public class Racing {

    private Cars cars;
    private int racingCount;

    protected Racing(String[] carNames, int racingCount) {
        this.cars = Cars.create(carNames);
        this.racingCount = racingCount;
    }

    public static Racing create(String[] carNames, int racingCount) {
        return new Racing(carNames, racingCount);
    }

    public void racing() {
        cars.moving();
        racingCount--;
    }

    public boolean isTryRacing() {
        return racingCount > 0;
    }

    public List<Car> racingResult() {
        return cars.getRacingResult();
    }

    public List<Car> winner() {
        return cars.findWinner();
    }
}
