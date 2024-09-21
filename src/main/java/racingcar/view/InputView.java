package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;
import racingcar.exception.ErrorCode;

public class InputView {
    private static final String SPLIT_PATTERN = ",";
    private static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_COUNTS = "시도할 회수는 몇회인가요?";
    private static final int MIN_RACING_COUNT = 0;
    private static final int MAX_CARNAME_LENGTH = 5;

    public String[] inputCarNames() {
        Scanner scanner = new Scanner(System.in);
        return inputCarNameAndValidateLengthName(scanner);
    }

    private String[] inputCarNameAndValidateLengthName(Scanner sc) {
        while (true) {
            String[] carNames = inputCarNamesByUser(sc);
            try {
                validCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                printCarNameExceptionMessage(e);
            }
        }
    }

    private String[] inputCarNamesByUser(Scanner sc) {
        System.out.println(INPUT_CARS);
        return inputSplit(sc);
    }

    private String[] inputSplit(Scanner sc) {
        return sc.nextLine().split(SPLIT_PATTERN);
    }

    private void validCarNames(String[] carNames) {
        Arrays.stream(carNames)
                .filter(this::isCarNameLength)
                .forEach(carName -> throwCarNameLengthExceedException());
    }

    private boolean isCarNameLength(String carName) {
        return carName.length() > MAX_CARNAME_LENGTH;
    }

    private void throwCarNameLengthExceedException() {
        throw new IllegalArgumentException(ErrorCode.getCarNameLengthExceed());
    }

    private void printCarNameExceptionMessage(IllegalArgumentException e) {
        System.out.println(getExceptionMessage(e));
        System.out.println();
    }

    private String getExceptionMessage(IllegalArgumentException e) {
        return e.getMessage();
    }

    public int inputRacingCount() {
        Scanner sc = new Scanner(System.in);
        return inputAndValidateRacingCount(sc);
    }

    private int inputAndValidateRacingCount(Scanner sc) {
        while (true) {
            int racingCount = inputRacingCountByUser(sc);
            try {
                checkRacingCount(racingCount);
                return racingCount;
            } catch (IllegalArgumentException exception) {
                printRacingCountExceptionMessage(exception);
            }
        }
    }

    private int inputRacingCountByUser(Scanner sc) {
        System.out.println(INPUT_RACING_COUNTS);
        return sc.nextInt();
    }

    private void checkRacingCount(int racingCount) {
        if (isNotRacingCountValid(racingCount)) {
            throwInvalidRacingCountMinimumException();
        }
    }

    private void printRacingCountExceptionMessage(IllegalArgumentException exception) {
        System.out.println(getExceptionMessage(exception));
        System.out.println();
    }

    private boolean isNotRacingCountValid(int racingCount) {
        return racingCount <= MIN_RACING_COUNT;
    }

    private void throwInvalidRacingCountMinimumException() {
        throw new IllegalArgumentException(ErrorCode.getInvalidRacingCountMinimum());
    }
}
