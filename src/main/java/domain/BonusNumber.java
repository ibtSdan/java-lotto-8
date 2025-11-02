package domain;


import constants.LottoConstants;
import message.ErrorMessage;

import java.util.List;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(String input, WinningNumbers winningNumbers){
        validateNotEmpty(input);
        validateLottoNumberRange(input);
        Integer number = Integer.parseInt(input);
        validateBonusNotInWinningNumbers(number, winningNumbers.getWinningNumbers());
        this.bonusNumber = number;
    }

    private void validateNotEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateLottoNumberRange(String input){
        if (!input.matches(LottoConstants.LOTTO_NUMBER_REGEX)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateBonusNotInWinningNumbers(Integer bonusNumber, List<Integer> winningNumbers){
        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
