package racingcar.exception;

public enum ErrorCode {
    CAR_NAME_LENGTH_EXCEEDED("자동차의 이름은 5글자를 초과할 수 없습니다."),
    INVALID_RACING_COUNT_MINIMUM("경주횟수는 최소 1 이상입니다."),
    DUPLICATE_CAR_NAME("자동차 이름이 중복 되었습니다.다시 입력해 주세요");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public static String getCarNameLengthExceed() {
        return CAR_NAME_LENGTH_EXCEEDED.message;
    }

    public static String getInvalidRacingCountMinimum() {
        return INVALID_RACING_COUNT_MINIMUM.message;
    }

    public static String getDuplicateCarName() {
        return DUPLICATE_CAR_NAME.message;
    }
}
