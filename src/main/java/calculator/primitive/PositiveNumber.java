package calculator.primitive;

import calculator.exception.ErrorCode;

public class PositiveNumber {
    public static final int MIN_NUMBER = 0;

    private final int number;

    private PositiveNumber(int number) {
        outOfNumber(number);
        this.number = number;
    }

    private static void outOfNumber(int index) {
        if (isOutOfNumber(index)) {
            throwException();
        }
    }

    private static boolean isOutOfNumber(int i) {
        return i < MIN_NUMBER;
    }

    private static void throwException() {
        throw new RuntimeException(ErrorCode.invalidInputException());
    }

    public int getNumber() {
        return this.number;
    }

    public static PositiveNumber create(int number) {
        return new PositiveNumber(number);
    }
}
