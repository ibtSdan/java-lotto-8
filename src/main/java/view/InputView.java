package view;

import provider.InputProvider;

public class InputView {
    private static final String MESSAGE_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final InputProvider provider;

    public InputView(InputProvider provider) {
        this.provider = provider;
    }

    public String inputPurchaseAmount(){
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return getInput();
    }

    public String inputWinningNumbers(){
        System.out.println(MESSAGE_WINNING_NUMBERS);
        return getInput();
    }

    public String inputBonusNumber(){
        System.out.println(MESSAGE_BONUS_NUMBER);
        return getInput();
    }

    private String getInput() {
        String input = provider.input();
        System.out.println();
        return input;
    }
}
