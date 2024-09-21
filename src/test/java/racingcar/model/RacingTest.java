package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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

    @DisplayName("우승 자동차를 반환한다.")
    @Test
    void findWinner() {
        //given
        //경주를 진행 시켜야 함
        String[] carName = {"car1", "car2", "car3"};
        int racingCOunt = 5;

        Racing racing = new Racing(carName, racingCOunt);

        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 4);
        Car car3 = new Car("car3", 2);

        Cars cars = new Cars(List.of(car1, car2, car3));

        //when
        List<String> winner = racing.winner();

        //then
        assertThat(winner).hasSize(1);
    }
}