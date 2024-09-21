package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;
import racingcar.model.util.numbergenerator.CustomNumberGenerator;
import racingcar.model.util.winnerstrategy.MaxForwordPositionStretegy;

class CarsTest {

    @DisplayName("cars를 생성할 때 중복된 이름이 있다면 예외를 던진다.")
    @Test
    void create() {
        //given
        List<Car> cars = List.of(
                new Car("car1", 1),
                new Car("car1", 1),
                new Car("car3", 1)
        );

        //when //then
        assertThatThrownBy(() -> Cars.create(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.getDuplicateCarName());
    }

    @DisplayName("가장 전진을 많이 한 자동차가 우승 자동차 이다.")
    @Test
    void findMostMovedCar() {
        //given
        Car car1 = new Car("car1", new CustomNumberGenerator(5));
        Car car2 = new Car("car2", new CustomNumberGenerator(4));
        Car car3 = new Car("car3", new CustomNumberGenerator(3));

        List<Car> carsName = List.of(car1, car2, car3);

        Cars cars = Cars.create(carsName);

        cars.moving();

        //when
        List<String> winner = cars.findWinner(new RacingJudge(cars, new MaxForwordPositionStretegy()));

        //then
        assertThat(winner).hasSize(2);
    }


    @DisplayName("가장 많이 전진한 자동차의 전진값을 반환한다.")
    @Test
    void getMaxForword() {
        //given
        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 2);
        Car car3 = new Car("car3", 1);

        Cars cars = Cars.create(List.of(car1, car2, car3));

        //when
        int result = cars.maxForwordPositionCount();

        //then
        assertThat(result).isEqualTo(5);
    }
}
