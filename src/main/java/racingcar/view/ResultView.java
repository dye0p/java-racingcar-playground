package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.dto.CarDto;

public class ResultView {

    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String POSITION_INDICATOR = "-";
    private static final String COMMA = ", ";

    public void racingResultInformation() {
        oneLineSpace();
        System.out.println(RACING_RESULT_MESSAGE);
    }

    private void oneLineSpace() {
        System.out.println();
    }

    public void racingResult(List<CarDto> result) {
        result.forEach(car -> {
            StringBuilder sb = new StringBuilder();
            appendByPositionCount(car, sb);

            printRacingResult(car, sb);
        });
        oneLineSpace();
    }

    private void appendByPositionCount(CarDto car, StringBuilder sb) {
        IntStream.range(0, car.getPosition())
                .forEach(position -> sb.append(POSITION_INDICATOR));
    }

    private void printRacingResult(CarDto car, StringBuilder sb) {
        System.out.println(car.getName() + NAME_POSITION_DELIMITER + sb);
    }

    public void resultWinner(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (String winner : winners) {

            if (winner.equals(winners.get(winners.size() - 1))) {
                sb.append(winner);
                printRacingWinner(sb);
            }
            appendByWinnerName(winner, sb);
        }
    }

    private void appendByWinnerName(String winner, StringBuilder sb) {
        sb.append(winner).append(COMMA);
    }

    private void printRacingWinner(StringBuilder sb) {
        System.out.println(sb + RACING_WINNER_MESSAGE);
    }
}
