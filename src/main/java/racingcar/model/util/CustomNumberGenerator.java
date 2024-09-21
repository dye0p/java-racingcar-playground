package racingcar.model.util;

public class CustomNumberGenerator implements NumberGenerator {

    private final int number;

    public CustomNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int createRandomNumber() {
        return number;
    }
}
