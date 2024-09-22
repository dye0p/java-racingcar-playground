package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.util.numbergenerator.RandomNumberGenerator;

class CarTest {

    @DisplayName("Car가 생성될때 기본 포지션 값은 0 이다.")
    @Test
    void createCarWithDefaultPositionIsZero() {
        //given //when
        Car car = new Car("car", new RandomNumberGenerator());

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("랜덤값이 4 이상이면 자동차가 전진한다.")
    @Test
    void canMove() {
        //given
        Car car = new Car("car", () -> 4);

        //when
        car.move();

        //then
        int position = car.getPosition();

        assertThat(position).isEqualTo(1);
    }

    @DisplayName("랜덤값이 4 이하라면 자동차가 전진하지 않는다.")
    @Test
    void notMove() {
        //given
        int boundaryNumber = 3;
        Car car = new Car("car", () -> 3);

        //when
        car.move();

        //then
        int position = car.getPosition();

        assertThat(position).isEqualTo(0);
    }

    @DisplayName("현재 포지션 값이 비교하려는 포지션 값과 같다면 true 반환")
    @Test
    void hasPositionCountOf() {
        //given
        Car car = new Car("car1", 3);
        int maxPositionCount = 3;

        //when
        boolean result = car.hasPositionCountOf(maxPositionCount);

        //then
        assertThat(result).isTrue();
    }

}