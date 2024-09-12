package calculator.primitive;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.StringSeparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSeparatorTest {

    private StringSeparator separator;

    @BeforeEach
    void setUp() {
        separator = new StringSeparator();
    }

    @DisplayName("문자열을 기본 구분자를 기준으로 분리한다.")
    @Test
    void splitStringWithDefaultPattern() {
        //given
        String text = "1,2,3";

        //when
        String[] strings = separator.splitString(text);

        //then
        assertThat(strings).contains("1", "2", "3");
    }

    @DisplayName("문자열을 정규 표현식을 기준으로 분리한다.")
    @Test
    void splitStringWithCustomPattern() {

        //given
        String text = "//;\n1;2;3";

        //when
        String[] strings = separator.splitString(text);

        //then
        assertThat(strings).contains("1", "2", "3");
    }


}