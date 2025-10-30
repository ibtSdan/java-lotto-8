package validator;

import java.util.List;

public class BonusNumberValidator {
    private BonusNumberValidator() {}

    public static void notEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    public static void checkLottoNumberRange(String input){
        if (!input.matches("[1-9]|[1-3][0-9]|4[0-5]")){
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45이하의 정수여야 합니다.");
        }
    }
}
