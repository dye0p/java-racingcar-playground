package racingcar.model.util.winnerstrategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

class MaxForwordPositionStretegyTest {

    private MaxForwordPositionStretegy maxForwordPositionStretegy;

    @DisplayName("가장 많이 전진한 자동차를 반환한다.")
    @Test
    void findWinnerCarNames() {
        //given

        //자동차 생성
        Car car1 = Car.create("car1", () -> 5);
        Car car2 = Car.create("car2", () -> 4);
        Car car3 = Car.create("car3", () -> 0);

        //전진
        car1.move();
        car1.move();

        car2.move();

        car3.move();

        Cars cars = Cars.create(List.of(car1, car2, car3));

        //when
        maxForwordPositionStretegy = new MaxForwordPositionStretegy();

        List<String> winnerCarNames = maxForwordPositionStretegy.findWinnerCarNames(cars);

        //then
        assertThat(winnerCarNames).hasSize(1);
    }

}