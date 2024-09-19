package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.util.RandomNumberCreator;

public class Racing {

    private List<Car> cars;
    private int racingCount;

    protected Racing(String[] carNames, int racingCount) {
        this.cars = creatCarGroup(carNames);
        this.racingCount = racingCount;
    }

    public List<Car> creatCarGroup(String[] carNames) {
        cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void racing() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.move(new RandomNumberCreator().createRandomNubmer());
        }
        racingCount--;
    }

    public boolean isTryRacing() {
        return racingCount > 0;
    }

    public List<Car> racingResult() {
        return cars;
    }

    public List<Car> winner() {
        RacingJudge racingJudge = new RacingJudge();
        return racingJudge.findWinner(cars);
    }

    public static Racing create(String[] carNames, int racingCount) {
        return new Racing(carNames, racingCount);
    }
}
