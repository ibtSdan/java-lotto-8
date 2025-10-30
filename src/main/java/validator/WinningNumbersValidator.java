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
}
