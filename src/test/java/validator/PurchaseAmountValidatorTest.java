package validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PurchaseAmountValidatorTest {

    @Nested
    @DisplayName("성공 입력 테스트")
    class ValidInputTest{

        @Test
        void notEmpty_정상(){
            assertDoesNotThrow(() -> PurchaseAmountValidator.notEmpty("a"));
        }

        @Test
        void positive_정상(){
            assertDoesNotThrow(() -> PurchaseAmountValidator.positive("3"));
        }

        @Test
        void multipleOfThousand_정상(){
            assertDoesNotThrow(() -> PurchaseAmountValidator.multipleOfThousand(3000));
        }
    }

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

        @Test
        void 입력이_1000_으로_나누어_떨어지지_않는다(){
            assertThatThrownBy(() -> PurchaseAmountValidator.multipleOfThousand(500))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
