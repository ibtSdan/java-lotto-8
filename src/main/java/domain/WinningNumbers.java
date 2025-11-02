package domain;

import constants.LottoConstants;
import message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final String NUMBER_SEPARATOR = ",";
    private final List<Integer> winningNumbers;

    public WinningNumbers(String input){
        validateNotEmpty(input);
        List<String> tokens = Arrays.stream(input.split(NUMBER_SEPARATOR))
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
        if (tokens.size() != LottoConstants.LOTTO_SIZE){
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private void validateLottoNumberRange(List<String> tokens){
        for (String token : tokens){
            if (!token.matches(LottoConstants.LOTTO_NUMBER_REGEX)){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
