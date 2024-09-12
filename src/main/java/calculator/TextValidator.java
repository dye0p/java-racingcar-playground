package calculator;

public class TextValidator {

    public boolean isNullOrEmpty(String text) {
        if (isNull(text)) {
            return true;
        }
        return isEmpty(text);
    }

    private boolean isEmpty(String text) {
        return text.isEmpty();
    }

    private boolean isNull(String text) {
        return text == null;
    }

    public static TextValidator of() {
        return new TextValidator();
    }
}
