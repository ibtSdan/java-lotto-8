package service;

import domain.*;
import generator.NumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    @Test
    void 구매금액_만큼_로또_생성(){
        NumberGenerator generator = () -> List.of(1,2,3,4,5,6);
        LottoService service = new LottoService(generator);

        List<Lotto> result = service.purchaseLotto(new PurchaseAmount("3000"));

        assertThat(result).hasSize(3);
    }

    @ParameterizedTest
    @CsvSource({
            "FIRST,1",
            "SECOND,1",
            "THIRD,0",
            "FOURTH,0",
            "FIFTH,2",
            "MISS,0"
    })
    void 당첨_결과_정상_계산(Rank rank, int count){
        LottoService service = new LottoService(() -> null);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,45)),
                new Lotto(List.of(1,2,3,45,44,43)),
                new Lotto(List.of(4,5,6,45,44,43))
        );
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("45", winningNumbers);

        LottoResult result = service.calculateResult(lottos, winningNumbers, bonusNumber);

        assertThat(result.getResult().get(rank)).isEqualTo(count);
    }

    @Test
    void 수익률_계산_성공(){
        LottoService service = new LottoService(() -> null);
        LottoResult result = new LottoResult();
        result.addRank(Rank.FIFTH);
        result.addRank(Rank.FIFTH);
        PurchaseAmount amount = new PurchaseAmount("30000");

        double profitRate = service.calculateProfitRate(result, amount);

        assertThat(profitRate).isEqualTo(33.3);
    }
}
