package validator;

public class PurchaseAmountValidator {

    public static void notEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }
}
