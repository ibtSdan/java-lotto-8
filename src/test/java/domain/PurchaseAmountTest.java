package domain;

import message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PurchaseAmountTest {

    @Nested
    @DisplayName("성공 입력 테스트")
    class ValidInputTest{

        @Test
        void 정상_입력_성공(){
            assertDoesNotThrow(() -> new PurchaseAmount("3000"));
        }
    }

    @Nested
    @DisplayName("예외 입력 테스트")
    class InvalidInputTest{

        @Test
        void 빈_문자열_입력_예외(){
            assertThatThrownBy(() -> new PurchaseAmount(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.EMPTY_INPUT.getMessage());
        }

        @Test
        void 문자_입력_예외(){
            assertThatThrownBy(() -> new PurchaseAmount("a"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_POSITIVE.getMessage());
        }

        @Test
        void 음수_입력_예외(){
            assertThatThrownBy(() -> new PurchaseAmount("-3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_POSITIVE.getMessage());
        }

        @Test
        void zero_입력_예외(){
            assertThatThrownBy(() -> new PurchaseAmount("0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_POSITIVE.getMessage());
        }

        @Test
        void 정수_범위를_벗어나는_입력_예외(){
            assertThatThrownBy(() -> new PurchaseAmount("2147483648"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.LARGE_INPUT.getMessage());
        }

        @Test
        void 입력이_1000_으로_나누어_떨어지지_않는다_예외(){
            assertThatThrownBy(() -> new PurchaseAmount("500"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }
}
