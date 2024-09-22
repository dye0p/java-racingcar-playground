package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @DisplayName("경주가 생성 될때 자동차 리스트를 만든다.")
    @Test
    void creatRacingWithCreateCarGroup() {
        //given
        String[] carNames = {"car1", "car2", "car3"};
        int racingCount = 5;

        //when
        Racing racing = Racing.create(carNames, racingCount);

        //then
        assertThat(racing).extracting("cars")
                .isInstanceOf(Cars.class);
    }
}