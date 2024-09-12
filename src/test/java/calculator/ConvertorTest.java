package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.primitive.PositiveNumber;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertorTest {

    private Convertor convertor;

    @BeforeEach
    void setUp() {
        convertor = new Convertor();
    }

    @DisplayName("문자열을 PositiveNumber 타입의 리스트로 변환한다.")
    @Test
    void convertStringToInteger() {
        //given
        String[] strings = new String[]{"1", "2", "3"};

        //when
        List<PositiveNumber> result = convertor.convertStringToInteger(strings);

        //then
        assertThat(result)
                .isInstanceOf(List.class)
                .hasSize(3);
    }
}