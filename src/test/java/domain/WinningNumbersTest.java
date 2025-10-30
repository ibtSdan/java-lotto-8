package domain;

import message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningNumbersTest {

    @Nested
    @DisplayName("성공 입력 테스트")
    class ValidInputTest{

        @Test
        void 정상_입력_성공(){
            assertDoesNotThrow(() -> new WinningNumbers("1,2,3,4,5,6"));
        }

    }

    @Nested
    @DisplayName("예외 입력 테스트")
    class InvalidInputTest{

        @Test
        void 빈_문자열_입력(){
            assertThatThrownBy(() -> new WinningNumbers(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.EMPTY_INPUT.getMessage());
        }

        @Test
        void 길이가_6이_아닌_입력(){
            assertThatThrownBy(() -> new WinningNumbers("a,b,c"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }

        @Test
        void 숫자가_아닌_입력(){
            assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,1a"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        @Test
        void 범위를_벗어나는_입력(){
            assertThatThrownBy(() -> new WinningNumbers("1,2,3,47,5,6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
