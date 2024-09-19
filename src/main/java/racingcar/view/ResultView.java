package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class ResultView {

    public void racingResultInformation() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void racingResult(List<Car> result) {
        StringBuilder sb;
        for (int i = 0; i < result.size(); i++) {
            sb = new StringBuilder();
            int position = result.get(i).getPosition();
            for (int j = 0; j < position; j++) {
                sb.append("-");
            }
            System.out.println(result.get(i).getName() + " : " + sb);
        }
        System.out.println();
    }

    public void resultWinner(List<Car> winners) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < winners.size() - 1; i++) {
            String winner = winners.get(i).getName();
            sb.append(winner).append(", ");
        }

        String lastWinner = winners.get(winners.size() -1).getName();
        sb.append(lastWinner);

        System.out.println(sb + "가 최종 우승했습니다.");
    }
}
