package calculator.exception;

public enum ErrorCode {

    INVALID_INPUT_ERROR_MESSAGE("유효하지 않은 입력 입니다.");

    private final String text;

    ErrorCode(String text) {
        this.text = text;
    }

    public static String invalidInputException() {
        return INVALID_INPUT_ERROR_MESSAGE.text;
    }
}


