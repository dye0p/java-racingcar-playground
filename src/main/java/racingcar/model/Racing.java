package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.dto.CarDto;
import racingcar.model.util.numbergenerator.RandomNumberGenerator;
import racingcar.model.util.winnerstrategy.MaxForwordPositionStretegy;

public class Racing {

    public static final int ONE_COUNT = 1;
    public static final int MIN_RACNIG_COUNT = 0;

    private final Cars cars;
    private int racingCount;

    protected Racing(String[] carNames, int racingCount) {
        List<Car> carList = convertToCarList(carNames);
        this.cars = Cars.create(carList);
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
        deductRacingCount();
    }

    private void deductRacingCount() {
        racingCount -= ONE_COUNT;
    }

    public boolean isTryRacing() {
        return racingCount > MIN_RACNIG_COUNT;
    }

    public List<CarDto> currentRacingResult() {
        return cars.getRacingResult();
    }

    public List<String> winner() {
        RacingJudge racingJudge = new RacingJudge(cars, new MaxForwordPositionStretegy());
        return cars.findWinner(racingJudge);
    }
}
