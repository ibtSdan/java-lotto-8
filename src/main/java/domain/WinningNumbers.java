package domain;

import validator.WinningNumbersValidator;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String input){
        WinningNumbersValidator.notEmpty(input);
        List<String> tokens = List.of(input.split(","));
        WinningNumbersValidator.checkSize(tokens);
        WinningNumbersValidator.checkLottoNumberRange(tokens);
        this.winningNumbers = tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
