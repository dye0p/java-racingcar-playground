package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final String MATCHER_PATTERN = "//(.)\n(.*)";
    public static final String SPLIT_PATTERN = "[,:]";
    public static final int GROUP_INDEX_1 = 1;
    public static final int GROUP_INDEX_2 = 2;
    public static final int MIN_NUMBER = 0;

    public static int splitAndSum(String text) {
        if (isNulOrEmpty(text)) {
            return ZERO;
        }
        return sumInput(convertStringToInteger(splitString(text)));
    }

    private static boolean isNulOrEmpty(String text) {
        if (isNull(text)) {
            return true;
        }
        return isEmpty(text);
    }

    private static boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }

    private static int sumInput(List<Integer> integers) {
        return integers.stream()
                .mapToInt(StringAddCalculator::validOutOfNumber)
                .sum();
    }

    private static Integer validOutOfNumber(Integer index) {
        outOfNumber(index);
        return index;
    }

    private static void outOfNumber(Integer index) {
        if (isOutOfNumber(index)) {
            throwException();
        }
    }

    private static boolean isOutOfNumber(Integer i) {
        return i < MIN_NUMBER;
    }

    private static void throwException() {
        throw new RuntimeException("유효하지 않은 입력 입니다.");
    }

    private static List<Integer> convertStringToInteger(String[] strings) {
        return Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] splitString(String text) {
        Matcher matcher = compileMatcher(text);

        if (isFindMatcher(matcher)) {
            return extractTokensSplit(matcher);
        }

        return text.split(SPLIT_PATTERN);
    }

    private static String[] extractTokensSplit(Matcher matcher) {
        return extractInputTokens(matcher).split(extractCustomDelimiter(matcher));
    }

    private static Matcher compileMatcher(String text) {
        return Pattern.compile(MATCHER_PATTERN).matcher(text);
    }

    private static boolean isFindMatcher(Matcher matcher) {
        return matcher.find();
    }

    private static String extractCustomDelimiter(Matcher m) {
        return m.group(GROUP_INDEX_1);
    }

    private static String extractInputTokens(Matcher m) {
        return m.group(GROUP_INDEX_2);
    }
}
