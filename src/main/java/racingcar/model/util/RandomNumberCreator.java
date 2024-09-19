package racingcar.model.util;

import java.util.Random;

public class RandomNumberCreator {

    public static final int RANDOM_NUMBER_BOUND = 9;

    public int createRandomNubmer() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
