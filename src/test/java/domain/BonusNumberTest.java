package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberTest {
    WinningNumbers wn;

    @BeforeEach
    void setUp(){
        wn = new WinningNumbers("1,2,3,4,5,6");
    }

    @Nested
    @DisplayName("성공 입력 테스트")
    class ValidInputTest {

        @Test
        void 정상_입력_성공(){
            assertDoesNotThrow(() -> new BonusNumber("10", wn));
        }

    }

    @Nested
    @DisplayName("예외 입력 테스트")
    class InvalidInputTest{

        @Test
        void 빈_문자열_입력(){
            assertThatThrownBy(() -> new BonusNumber("", wn))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자가_아닌_입력(){
            assertThatThrownBy(() -> new BonusNumber("a", wn))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 범위를_벗어나는_입력(){
            assertThatThrownBy(() -> new BonusNumber("46", wn))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 당첨_숫자와_중복되면_예외(){
            assertThatThrownBy(() -> new BonusNumber("1", wn))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
