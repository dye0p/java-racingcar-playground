package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextValidatorTest {

    private TextValidator textValidator;

    @BeforeEach
    void setUp() {
        textValidator = new TextValidator();
    }

    @DisplayName("문자열이 비었다면 true를 리턴한다")
    @Test
    void isEmpty() {
        //given
        String text = "";

        //when
        boolean result = textValidator.isNullOrEmpty(text);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("문자열이 null이면 true를 리턴한다")
    @Test
    void isNull() {
        //given //when
        boolean result = textValidator.isNullOrEmpty(null);

        //then
        assertThat(result).isTrue();
    }
}