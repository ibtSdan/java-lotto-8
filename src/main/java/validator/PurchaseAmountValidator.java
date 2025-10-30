package validator;

public class PurchaseAmountValidator {

    private PurchaseAmountValidator() {}

    public static void notEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    public static void positive(String input){
        if (!input.matches("0*[1-9]\\d+")){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
    }
}
