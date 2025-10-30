package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberValidatorTest {

    @Nested
    @DisplayName("성공 입력 테스트")
    class ValidInputTest {

        @Test
        void notEmpty_성공() {
            assertDoesNotThrow(() -> BonusNumberValidator.notEmpty("a"));
        }

        @Test
        void checkLottoNumberRange_성공(){
            assertDoesNotThrow(() -> BonusNumberValidator.checkLottoNumberRange("24"));
        }

    }

    @Nested
    @DisplayName("예외 입력 테스트")
    class InvalidInputTest{

        @Test
        void 빈_문자열_입력(){
            assertThatThrownBy(() -> BonusNumberValidator.notEmpty(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자가_아닌_입력(){
            assertThatThrownBy(() -> BonusNumberValidator.checkLottoNumberRange("a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 범위를_벗어나는_입력(){
            assertThatThrownBy(() -> BonusNumberValidator.checkLottoNumberRange("46"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
