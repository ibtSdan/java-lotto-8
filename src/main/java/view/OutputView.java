package view;

import domain.Lotto;
import domain.LottoResult;
import domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String MESSAGE_PURCHASE_COUNT = "%d개를 구매했습니다.%n";
    public static final String MESSAGE_STATISTICS_HEADER = "당첨 통계";
    public static final String MESSAGE_DIVIDER = "---";
    public static final String MESSAGE_PROFIT_RATE = "총 수익률은 %.1f%%입니다.%n";

    private static final String MESSAGE_FIFTH = "3개 일치 (5,000원) - %d개%n";
    private static final String MESSAGE_FOURTH = "4개 일치 (50,000원) - %d개%n";
    private static final String MESSAGE_THIRD = "5개 일치 (1,500,000원) - %d개%n";
    private static final String MESSAGE_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n";
    private static final String MESSAGE_FIRST = "6개 일치 (2,000,000,000원) - %d개%n";

    public void printPurchaseCount(int count){
        System.out.printf(MESSAGE_PURCHASE_COUNT, count);
    }

    public void printLottos(List<Lotto> lottos){
        for (Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResult(LottoResult LottoResult, double profitRate){
        System.out.println(MESSAGE_STATISTICS_HEADER);
        System.out.println(MESSAGE_DIVIDER);
        Map<Rank, Integer> result = LottoResult.getResult();
        printFormat(MESSAGE_FIFTH, result.get(Rank.FIFTH));
        printFormat(MESSAGE_FOURTH, result.get(Rank.FOURTH));
        printFormat(MESSAGE_THIRD, result.get(Rank.THIRD));
        printFormat(MESSAGE_SECOND, result.get(Rank.SECOND));
        printFormat(MESSAGE_FIRST, result.get(Rank.FIRST));
        printFormat(MESSAGE_PROFIT_RATE, profitRate);
    }

    public void printError(String message){
        System.out.println(message);
    }

    private void printFormat(String format, Object... args){
        System.out.printf(format, args);
    }
}
