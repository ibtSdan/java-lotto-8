package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @ParameterizedTest
    @CsvSource({
            "6,false,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,false,FOURTH",
            "3,false,FIFTH",
            "2,false,MISS"
    })
    void 일치_개수와_보너스_여부에_따라_Rank_생성(int matchCount, boolean matchBonus, Rank expected){
        Rank result = Rank.of(matchCount, matchBonus);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
