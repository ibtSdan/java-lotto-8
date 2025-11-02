package generator;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstants;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator{
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER, LottoConstants.LOTTO_SIZE);
    }
}
