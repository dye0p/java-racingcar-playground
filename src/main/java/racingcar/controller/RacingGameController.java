package racingcar.controller;

import java.util.List;
import racingcar.exception.ErrorCode;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {

    private final InputView inputView;
    private final ResultView resultView;
    private Racing racing;

    public RacingGameController() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void readyRacing() {
        String carNames;
        int racingCount;

        while (true) {
            try {
                carNames = inputView.inputCarNames();
                String[] splitCarNames = carNames.split(",");

                for (String carName : splitCarNames) {
                    if (carName.length() > 5) {
                        throw new IllegalArgumentException(ErrorCode.CAR_NAME_LENGTH_EXCEEDED.getMessage());
                    }
                }
                racingCount = inputView.inputRacingCount();

                racing = new Racing(splitCarNames, racingCount);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void startRacing() {
        resultView.racingResultInformation();
        while (racing.isTryRacing()) {
            racing.racing();
            List<Car> cars = racing.racingResult();
            resultView.racingResult(cars);
        }
    }

    public void racingWinner() {
        List<Car> winners = racing.winner();
        resultView.resultWinner(winners);
    }
}