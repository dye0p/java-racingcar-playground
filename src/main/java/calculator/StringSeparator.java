package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    public static final String MATCHER_PATTERN = "//(.)\n(.*)";
    public static final String SPLIT_PATTERN = "[,:]";
    public static final int GROUP_INDEX_1 = 1;
    public static final int GROUP_INDEX_2 = 2;

    public String[] splitString(String text) {
        Matcher matcher = compileMatcher(text);

        if (isFindMatcher(matcher)) {
            return extractTokensSplit(matcher);
        }

        return text.split(SPLIT_PATTERN);
    }

    private Matcher compileMatcher(String text) {
        return patternCompile().matcher(text);
    }

    private Pattern patternCompile() {
        return Pattern.compile(MATCHER_PATTERN);
    }

    private boolean isFindMatcher(Matcher matcher) {
        return matcher.find();
    }

    private String[] extractTokensSplit(Matcher matcher) {
        return extractInputTokens(matcher).split(extractCustomDelimiter(matcher));
    }

    private static String extractCustomDelimiter(Matcher m) {
        return m.group(GROUP_INDEX_1);
    }

    private static String extractInputTokens(Matcher m) {
        return m.group(GROUP_INDEX_2);
    }

    public static StringSeparator of() {
        return new StringSeparator();
    }
}

