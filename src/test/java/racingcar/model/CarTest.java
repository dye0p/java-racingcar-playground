package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("랜덤값이 4 이상이면 자동차가 전진한다.")
    @Test
    void move() {
        //given
        Car car = new Car("dyeop");
        int randomNumber = 4;

        //when
        car.move(randomNumber);

        //then
        int position = car.getPosition();

        assertThat(position).isEqualTo(1);
    }

    @DisplayName("랜덤값이 4 이하라면 자동차가 전진하지 않는다.")
    @Test
    void notMove() {
        //given
        Car car = new Car("dyeop");
        int randomNumber = 3;

        //when
        car.move(randomNumber);

        //then
        int position = car.getPosition();

        assertThat(position).isEqualTo(0);
    }

}