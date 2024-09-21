package racingcar.controller;

import java.util.List;
import racingcar.model.Racing;
import racingcar.model.dto.CarDto;
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
        while (true) {
            String[] carNames = inputView.inputCarNames();
            int racingCount = inputView.inputRacingCount();

            try {
                createRacing(carNames, racingCount);
                break;
            } catch (IllegalArgumentException e) {
                throwInputExeption(e);
            }
        }
    }

    private void createRacing(String[] carNames, int racingCount) {
        racing = Racing.create(carNames, racingCount);
    }

    private void throwInputExeption(IllegalArgumentException e) {
        System.out.println(getExceptionMessage(e));
        System.out.println();
    }

    private String getExceptionMessage(IllegalArgumentException e) {
        return e.getMessage();
    }

    public void startRacing() {
        resultView.racingResultInformation();
        while (racing.isTryRacing()) {
            racing.racing();
            List<CarDto> cars = racing.currentRacingResult();
            resultView.racingResult(cars);
        }
    }

    public void racingWinner() {
        List<String> winners = racing.winner();
        resultView.resultWinner(winners);
    }
}