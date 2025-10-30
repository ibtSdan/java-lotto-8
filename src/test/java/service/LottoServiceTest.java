package service;

import domain.Lotto;
import domain.PurchaseAmount;
import generator.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    @Nested
    @DisplayName("성공 테스트")
    class ValidTest{

        @Test
        void 구매금액_만큼_로또_생성(){
            NumberGenerator generator = () -> List.of(1,2,3,4,5,6);
            LottoService service = new LottoService(generator);

            List<Lotto> result = service.purchaseLotto(new PurchaseAmount("3000"));

            assertThat(result).hasSize(3);
        }
    }
}
