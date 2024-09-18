package racingcar.model.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberCreatorTest {

    private RandomNumberCreator randomNumberCreator;

    @BeforeEach
    void setUp() {
        randomNumberCreator = new RandomNumberCreator();
    }

    @DisplayName("0 부터 9 까지의 난수 한자리를 생성한다.")
    @Test
    void createRandomNubmer() {
        //given //when
        int randomNubmer = randomNumberCreator.createRandomNubmer();

        //then
        assertThat(randomNubmer).isBetween(0, 9);
    }

}