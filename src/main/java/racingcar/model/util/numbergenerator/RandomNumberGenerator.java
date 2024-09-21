package racingcar.model.util.numbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int RANDOM_NUMBER_BOUND = 9;
    public static final Random RANDOM = new Random();

    @Override
    public int createRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }

    public static RandomNumberGenerator create() {
        return new RandomNumberGenerator();
    }
}
