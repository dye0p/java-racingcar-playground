package racingcar.model;

public class Car {

    public static final int ONE_PORWORD = 1;
    public static final int MIN_NUMBER_RANGE = 4;
    public static final int SET_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = SET_POSITION;
    }

    public void move(int randomNumber) {
        if (isMovable(randomNumber)) {
            carForword();
        }
    }

    private void carForword() {
        this.position += ONE_PORWORD;
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MIN_NUMBER_RANGE;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
