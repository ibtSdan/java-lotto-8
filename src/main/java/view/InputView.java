package view;

import provider.InputProvider;

public class InputView {
    private final InputProvider provider;

    public InputView(InputProvider provider) {
        this.provider = provider;
    }

    public String inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return getInput();
    }

    public String inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return getInput();
    }

    public String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return getInput();
    }

    private String getInput() {
        String input = provider.input();
        System.out.println();
        return input;
    }
}
