package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class PurchaseAmountValidatorTest {

    @Nested
    @DisplayName("예외 입력 테스트")
    class InvalidInputTest{

        @Test
        void 빈_문자열_입력(){
            assertThatThrownBy(() -> PurchaseAmountValidator.notEmpty(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 문자_입력(){
            assertThatThrownBy(() -> PurchaseAmountValidator.positive("a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 음수_입력(){
            assertThatThrownBy(() -> PurchaseAmountValidator.positive("-3"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void zero_입력(){
            assertThatThrownBy(() -> PurchaseAmountValidator.positive("0"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
