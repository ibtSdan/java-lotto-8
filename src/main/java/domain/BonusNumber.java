package domain;

import validator.BonusNumberValidator;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(String input, WinningNumbers winningNumbers){
        BonusNumberValidator.notEmpty(input);
        BonusNumberValidator.checkLottoNumberRange(input);
        Integer number = Integer.parseInt(input);
        BonusNumberValidator.checkBonusNotInWinningNumbers(number, winningNumbers.getWinningNumbers());
        this.bonusNumber = number;
    }
}
