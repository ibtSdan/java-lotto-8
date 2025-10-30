package domain;


import message.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validatePositive(String input){
        if (!input.matches("[1-9]\\d*")){
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.getMessage());
        }
    }

    private void validateIntegerRange(String input){
        String maxInt = "2147483647";
        if (input.length()>10 || input.length()==10 && input.compareTo(maxInt) > 0){
            throw new IllegalArgumentException(ErrorMessage.LARGE_INPUT.getMessage());
        }
    }

    private void validateMultipleOfThousand(Integer money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }
}
