package calculator;

import calculator.primitive.PositiveNumber;
import java.util.List;

public class StringAddCalculator {

    public static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (isTextValidation(text)) {
            return ZERO;
        }

        return sumInput(convertStringToInteger(splitString(text)));
    }

    private static boolean isTextValidation(String text) {
        TextValidator textValidator = TextValidator.of();
        return textValidator.isNullOrEmpty(text);
    }

    private static int sumInput(List<PositiveNumber> integers) {
        return integers.stream()
                .mapToInt(PositiveNumber::getNumber)
                .sum();
    }

    private static List<PositiveNumber> convertStringToInteger(String[] strings) {
        Convertor convertor = Convertor.of();
        return convertor.convertStringToInteger(strings);
    }

    private static String[] splitString(String text) {
        StringSeparator stringSeparator = StringSeparator.of();
        return stringSeparator.splitString(text);
    }
}
