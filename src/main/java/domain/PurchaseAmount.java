package domain;


public class PurchaseAmount {
    private final int value;

    public PurchaseAmount(String input){
        validateNotEmpty(input);
        validatePositive(input);
        validateIntegerRange(input);
        int money = Integer.parseInt(input);
        validateMultipleOfThousand(money);
        this.value = money;
    }

    private void validateNotEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    private void validatePositive(String input){
        if (!input.matches("[1-9]\\d*")){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
    }

    private void validateIntegerRange(String input){
        String maxInt = "2147483647";
        if (input.length()>10 || input.length()==10 && input.compareTo(maxInt) > 0){
            throw new IllegalArgumentException("[ERROR] 입력값이 너무 큽니다.");
        }
    }

    private void validateMultipleOfThousand(Integer money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위어야 합니다.");
        }
    }
}
