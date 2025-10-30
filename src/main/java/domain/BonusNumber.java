package domain;


import java.util.List;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(String input, WinningNumbers winningNumbers){
        validateNotEmpty(input);
        validateLottoNumberRange(input);
        Integer number = Integer.parseInt(input);
        valiateBonusNotInWinningNumbers(number, winningNumbers.getWinningNumbers());
        this.bonusNumber = number;
    }

    private void validateNotEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    private void validateLottoNumberRange(String input){
        if (!input.matches("[1-9]|[1-3][0-9]|4[0-5]")){
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45이하의 정수여야 합니다.");
        }
    }

    private void valiateBonusNotInWinningNumbers(Integer bonusNumber, List<Integer> winningNumbers){
        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 숫자와 중복될 수 없습니다.");
        }
    }
}
