package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @Test
    void LottoResult_초기화_테스트(){
        LottoResult result = new LottoResult();

        for (Rank rank : Rank.values()){
            assertThat(result.getResult().get(rank)).isEqualTo(0);
        }
    }

    @Test
    void Rank_추가_테스트(){
        LottoResult result = new LottoResult();

        result.addRank(Rank.FIRST);
        result.addRank(Rank.FIRST);
        result.addRank(Rank.FOURTH);
        result.addRank(Rank.MISS);

        Map<Rank, Integer> expected = new EnumMap<Rank, Integer>(Rank.class);
        for (Rank rank : Rank.values()){
            expected.put(rank, 0);
        }
        expected.put(Rank.FIRST, 2);
        expected.put(Rank.FOURTH, 1);
        expected.put(Rank.MISS, 1);

        assertThat(result.getResult()).isEqualTo(expected);
    }

    @Test
    void 총_상금_계산_성공(){
        LottoResult result = new LottoResult();
        result.addRank(Rank.FIRST);
        result.addRank(Rank.FOURTH);
        result.addRank(Rank.FIFTH);

        int totalPrize = result.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(2000055000);
    }
}
