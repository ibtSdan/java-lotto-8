package service;

import domain.*;
import generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final NumberGenerator generator;

    public LottoService(NumberGenerator generator){
        this.generator = generator;
    }

    public List<Lotto> purchaseLotto(PurchaseAmount amount){
        int count = amount.getValue()/1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++){
            List<Integer> numbers = generator.generateNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public LottoResult calculateResult(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber){
        LottoResult result = new LottoResult();

        for(Lotto lotto : lottos){
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers.getWinningNumbers()::contains)
                    .count();
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber.getBonusNumber());

            Rank rank = Rank.of(matchCount, matchBonus);
            result.addRank(rank);
        }

        return result;
    }

    public double calculateProfitRate(LottoResult result, PurchaseAmount amount){
        int totalPrize = result.calculateTotalPrize();
        double profitRate = (double) totalPrize / amount.getValue() * 100.0;
        return Math.round(profitRate*10)/10.0;
    }
}
