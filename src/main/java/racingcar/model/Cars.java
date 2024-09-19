package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.ErrorCode;
import racingcar.model.util.RandomNumberCreator;

public class Cars {

    private List<Car> cars;

    protected Cars(String[] carNames) {
        validateDuplicateCarName(carNames);
        createCars(carNames);
    }

    public static Cars create(String[] craNames) {
        return new Cars(craNames);
    }

    private void validateDuplicateCarName(String[] carNames) {
        HashSet<String> hashSet = new HashSet<>();
        validateCarName(carNames, hashSet);
    }

    private void validateCarName(String[] carNames, HashSet<String> hashSet) {
        for (String carName : carNames) {
            checkAndThrowIfDuplicateCarName(carName, hashSet);
        }
    }

    private void checkAndThrowIfDuplicateCarName(String carName, HashSet<String> hashSet) {
        if (!isDuplicateCarName(carName, hashSet)) {
            throwDuplicateCarNameException();
        }
    }

    private boolean isDuplicateCarName(String carName, HashSet<String> hashSet) {
        return hashSet.add(carName);
    }

    private void throwDuplicateCarNameException() {
        throw new IllegalArgumentException(ErrorCode.getDuplicateCarName());
    }

    private void createCars(String[] carNames) {
        cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moving() {
        cars.forEach(car -> car.move(createRandomNumber()));
    }

    private int createRandomNumber() {
        return new RandomNumberCreator().createRandomNubmer();
    }

    public List<Car> getRacingResult() {
        return cars;
    }

    public List<Car> findWinner() {
        RacingJudge racingJudge = new RacingJudge();
        return racingJudge.findWinner(cars);
    }
}
