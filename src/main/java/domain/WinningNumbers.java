package domain;

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
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    private void validateSize(List<String> tokens){
        if (tokens.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 6개여야 합니다.");
        }
    }

    private void validateLottoNumberRange(List<String> tokens){
        for (String token : tokens){
            if (!token.matches("[1-9]|[1-3][0-9]|4[0-5]")){
                throw new IllegalArgumentException("[ERROR] 당첨 숫자는 1이상 45이하의 정수여야 합니다.");
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
