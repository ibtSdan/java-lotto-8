package domain;

import validator.PurchaseAmountValidator;

public class PurchaseAmount {
    private final int value;

    public PurchaseAmount(String input){
        PurchaseAmountValidator.notEmpty(input);
        PurchaseAmountValidator.positive(input);
        PurchaseAmountValidator.checkIntegerRange(input);
        int money = Integer.parseInt(input);
        PurchaseAmountValidator.multipleOfThousand(money);
        this.value = money;
    }
}
