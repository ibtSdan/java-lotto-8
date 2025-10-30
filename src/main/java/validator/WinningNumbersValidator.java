package validator;

import java.util.List;

public class WinningNumbersValidator {

    private WinningNumbersValidator() {}

    public static void notEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    public static void checkSize(List<String> tokens){
        if (tokens.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 6개여야 합니다.");
        }
    }

    public static void checkLottoNumberRange(List<String> tokens){
        for (String token : tokens){
            if (!token.matches("[1-9]|[1-3][0-9]|4[0-5]")){
                throw new IllegalArgumentException("[ERROR] 당첨 숫자는 1이상 45이하의 정수여야 합니다.");
            }
        }
    }
}
