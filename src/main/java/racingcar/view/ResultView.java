package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;

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

    public void racingResult(List<Car> result) {
        result.forEach(car -> {
            StringBuilder sb = new StringBuilder();
            appendByPositionCount(car, sb);

            printRacingResult(car, sb);
        });
        oneLineSpace();
    }

    private void appendByPositionCount(Car car, StringBuilder sb) {
        IntStream.range(0, car.getPosition())
                .forEach(position -> sb.append(POSITION_INDICATOR));
    }

    private void printRacingResult(Car car, StringBuilder sb) {
        System.out.println(car.getName() + NAME_POSITION_DELIMITER + sb);
    }

    public void resultWinner(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for (Car winner : winners) {
            appendByWinnerName(winner, sb);
        }
        appendByLastWinnerName(winners, sb);

        printRacingWinner(sb);
    }

    private void appendByWinnerName(Car winner, StringBuilder sb) {
        sb.append(winner.getName()).append(COMMA);
    }

    private void appendByLastWinnerName(List<Car> winners, StringBuilder sb) {
        sb.append(winners.get(winners.size() - 1).getName());
    }

    private void printRacingWinner(StringBuilder sb) {
        System.out.println(sb + RACING_WINNER_MESSAGE);
    }
}
