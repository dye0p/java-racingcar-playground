package racingcar.controller;

import java.util.List;
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
        String[] carNames = inputView.inputCarNames();
        int racingCount = inputView.inputRacingCount();

        racing = new Racing(carNames, racingCount);
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