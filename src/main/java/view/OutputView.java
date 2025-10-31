package view;

import domain.Lotto;
import domain.LottoResult;
import domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPurchaseCount(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos){
        for (Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResult(LottoResult result){
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Rank, Integer> map = result.getResult();
        System.out.printf("3개 일치 (5,000원) - %d개%n", map.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", map.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", map.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", map.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", map.get(Rank.FIRST));
    }

    public void printError(String message){
        System.out.println(message);
    }
}
