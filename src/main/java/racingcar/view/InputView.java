package racingcar.view;

import java.util.Scanner;
import racingcar.exception.ErrorCode;

public class InputView {

    public String inputCarNames() {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public int inputRacingCount() {
        Scanner sc = new Scanner(System.in);
        int racingCount = 0;

        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            racingCount = sc.nextInt();

            try {
                if (racingCount < 1) {
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
