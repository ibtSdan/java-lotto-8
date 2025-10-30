package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    }
}
