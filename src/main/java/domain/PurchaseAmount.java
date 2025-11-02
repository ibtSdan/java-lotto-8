package domain;


import message.ErrorMessage;

public class PurchaseAmount {
    private static final String POSITIVE_NUMBER_REGEX = "[1-9]\\d*";
    private static final int LOTTO_PRICE = 1000;
    private static final String MAX_INT_STRING = "2147483647";

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
        if (!input.matches(POSITIVE_NUMBER_REGEX)){
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.getMessage());
        }
    }

    private void validateIntegerRange(String input){
        if (input.length()>10 || input.length()==10 && input.compareTo(MAX_INT_STRING) > 0){
            throw new IllegalArgumentException(ErrorMessage.LARGE_INPUT.getMessage());
        }
    }

    private void validateMultipleOfThousand(Integer money){
        if (money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND.getMessage());
        }
    }

    public int countLottos(){
        return value / LOTTO_PRICE;
    }

    public int getValue() {
        return value;
    }
}
