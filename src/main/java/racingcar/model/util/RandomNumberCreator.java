package racingcar.model.util;

import java.util.Random;

public class RandomNumberCreator {

    public int createRandomNubmer() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
