package domain;

import message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String input){
        validateNotEmpty(input);
        List<String> tokens = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        validateSize(tokens);
        validateLottoNumberRange(tokens);
        this.winningNumbers = tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validateNotEmpty(String input){
        if (input == null || input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateSize(List<String> tokens){
        if (tokens.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private void validateLottoNumberRange(List<String> tokens){
        for (String token : tokens){
            if (!token.matches("[1-9]|[1-3][0-9]|4[0-5]")){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
