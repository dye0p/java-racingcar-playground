package racingcar.model;

import java.util.HashSet;
import java.util.List;
import racingcar.exception.ErrorCode;

public class Cars {

    private final List<Car> cars;

    protected Cars(List<Car> cars) {
        validateDuplicateCarName(cars);
        this.cars = cars;
    }

    public static Cars create(List<Car> craNames) {
        return new Cars(craNames);
    }

    private void validateDuplicateCarName(List<Car> carNames) {
        HashSet<String> hashSet = new HashSet<>();
        checkForDuplicateCarNames(carNames, hashSet);
    }

    private void checkForDuplicateCarNames(List<Car> carNames, HashSet<String> hashSet) {
        carNames.stream()
                .map(Car::getName)
                .forEach(carName -> checkAndThrowIfDuplicateCarName(carName, hashSet));
    }

    private void checkAndThrowIfDuplicateCarName(String carName, HashSet<String> hashSet) {
        if (isNotDuplicateCarName(carName, hashSet)) {
            return;
        }
        throwDuplicateCarNameException();
    }

    private boolean isNotDuplicateCarName(String carName, HashSet<String> hashSet) {
        return hashSet.add(carName);
    }

    private void throwDuplicateCarNameException() {
        throw new IllegalArgumentException(ErrorCode.getDuplicateCarName());
    }

    public void moving() {
        cars.forEach(Car::move);
    }

    public List<Car> getRacingResult() {
        return cars;
    }

    public List<Car> findWinner() {
        RacingJudge racingJudge = new RacingJudge();
        return racingJudge.findWinner(cars);
    }
}
