package racingcar.view;

import java.util.Scanner;
import racingcar.exception.ErrorCode;

public class InputView {
    private static final String REGEX = ",";
    private static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_COUNTS = "시도할 회수는 몇회인가요?";
    private static final int MIN_RACING_COUNT = 1;


    public String[] inputCarNames() {
        Scanner sc = new Scanner(System.in);

        System.out.println(INPUT_CARS);
        return inputSplit(sc);
    }

    private String[] inputSplit(Scanner sc) {
        return sc.nextLine().split(REGEX);
    }

    public int inputRacingCount() {
        Scanner sc = new Scanner(System.in);
        int racingCount = 0;

        while (true) {
            System.out.println(INPUT_RACING_COUNTS);
            racingCount = sc.nextInt();

            try {
                if (racingCount < MIN_RACING_COUNT) {
                    throw new IllegalArgumentException(ErrorCode.INVALID_RACING_COUNT_MINIMUM.getMessage());
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return racingCount;
    }
}
