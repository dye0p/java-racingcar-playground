package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;

class CarsTest {

    @DisplayName("cars를 생성할 때 중복된 이름이 있다면 예외를 던진다.")
    @Test
    void create() {
        //given
        String[] carsName = {"car1", "car1", "car3"};

        //when //then
        assertThatThrownBy(() -> Cars.create(carsName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.getDuplicateCarName());
    }
}