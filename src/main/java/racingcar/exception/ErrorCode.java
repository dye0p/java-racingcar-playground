package racingcar.exception;

public enum ErrorCode {
    CAR_NAME_LENGTH_EXCEEDED("자동차의 이름은 5글자를 초과할 수 없습니다."),
    INVALID_RACING_COUNT_MINIMUM("경주횟수는 최소 1 이상입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
