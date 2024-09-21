package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.util.RandomNumberGenerator;

public class Racing {

    private final Cars cars;
    private int racingCount;

    protected Racing(String[] carNames, int racingCount) {
        List<Car> cars = convertToCarList(carNames);
        this.cars = Cars.create(cars);
        this.racingCount = racingCount;
    }

    private List<Car> convertToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carName -> Car.create(carName, RandomNumberGenerator.create()))
                .collect(Collectors.toList());
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
