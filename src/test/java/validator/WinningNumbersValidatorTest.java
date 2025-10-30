package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class WinningNumbersValidatorTest {

    @Nested
    @DisplayName("성공 입력 테스트")
    class ValidInputTest{

        @Test
        void notEmpty_성공(){
            assertDoesNotThrow(() -> WinningNumbersValidator.notEmpty("a"));
        }

        @Test
        void checkSize_성공(){
            assertDoesNotThrow(() -> WinningNumbersValidator.checkSize(List.of("a", "b", "c", "d", "e", "f")));
        }

        @Test
        void checkAllNumeric_성공(){
            assertDoesNotThrow(() -> WinningNumbersValidator.checkLottoNumberRange(List.of("1", "2", "3", "4", "5", "6")));
        }
    }

    @Nested
    @DisplayName("예외 입력 테스트")
    class InvalidInputTest{

        @Test
        void 빈_문자열_입력(){
            assertThatThrownBy(() -> WinningNumbersValidator.notEmpty(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 길이가_6이_아닌_입력(){
            assertThatThrownBy(() -> WinningNumbersValidator.checkSize(List.of("a", "b")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자가_아닌_입력(){
            assertThatThrownBy(() -> WinningNumbersValidator.checkLottoNumberRange(List.of("1", "3", "43", "5", "17", "1a")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 범위를_벗어나는_입력(){
            assertThatThrownBy(() -> WinningNumbersValidator.checkLottoNumberRange(List.of("1", "3", "47", "5", "17", "18")))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
