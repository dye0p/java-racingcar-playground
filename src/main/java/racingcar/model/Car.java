package racingcar.model;

import racingcar.model.util.NumberGenerator;
import racingcar.model.util.RandomNumberGenerator;

public class Car {

    public static final int ONE_PORWORD = 1;
    public static final int MIN_NUMBER_RANGE = 4;
    public static final int SET_POSITION = 0;

    private final String name;
    private int position;
    private final NumberGenerator randomNumberGenerator;

    protected Car(String name, NumberGenerator randomNumberGenerator) {
        this.name = name;
        this.position = SET_POSITION;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    protected Car(String name) {
        this.name = name;
        this.position = SET_POSITION;
        this.randomNumberGenerator = this::createRandomNumber;
    }

    public static Car create(String name, RandomNumberGenerator randomNumberGenerator) {
        return new Car(name, randomNumberGenerator);
    }

    public void move() {
        if (isMovable()) {
            carForword();
        }
    }

    private boolean isMovable() {
        int randomNumber = createRandomNumber();
        return randomNumber >= MIN_NUMBER_RANGE;
    }

    private int createRandomNumber() {
        return randomNumberGenerator.createRandomNumber();
    }

    private void carForword() {
        this.position += ONE_PORWORD;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
