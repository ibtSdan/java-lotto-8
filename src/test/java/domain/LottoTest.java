package domain;

import message.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Nested
    @DisplayName("성공 테스트")
    class ValidTest{

        @Test
        void 성공(){
            Assertions.assertDoesNotThrow(() -> new Lotto(List.of(1,2,3,4,5,6)));
        }

        @Test
        void 오름차순_정렬_성공(){
            Lotto result = new Lotto(List.of(3,4,2,1,5,6));

            assertThat(result.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
        }

    }

    @Nested
    @DisplayName("예외 테스트")
    class InvalidTest{

        @Test
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 로또_번호가_1이상_45이하가_아니면_예외가_발생한다(){
            assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }
}
