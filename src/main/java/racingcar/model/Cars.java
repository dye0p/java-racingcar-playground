package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ErrorCode;
import racingcar.model.dto.CarDto;

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

    public List<CarDto> getRacingResult() {
        return cars.stream()
                .map(Car::getCars)
                .collect(Collectors.toList());
    }

    public List<String> findWinner(RacingJudge racingJudge) {
        return racingJudge.findWinner();
    }

    public int maxForwordPositionCount() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> compareCarPositions(int maxForwordPositionCount) {
        return cars.stream()
                .filter(car -> car.hasPositionCountOf(maxForwordPositionCount))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
