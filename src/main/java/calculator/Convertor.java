package calculator;

import calculator.primitive.PositiveNumber;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {

    public List<PositiveNumber> convertStringToInteger(String[] strings) {
        return Arrays.stream(strings)
                .map(index -> PositiveNumber.create(parseInteger(index)))
                .collect(Collectors.toList());
    }

    private int parseInteger(String index) {
        return Integer.parseInt(index);
    }

    public static Convertor of() {
        return new Convertor();
    }
}
