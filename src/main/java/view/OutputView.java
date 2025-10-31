package view;

import domain.Lotto;

import java.util.List;

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

    public void printError(String message){
        System.out.println(message);
    }
}
