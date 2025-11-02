package domain;

import constants.LottoConstants;
import message.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers){
        for (Integer number : numbers){
            if (number<LottoConstants.MIN_LOTTO_NUMBER || number>LottoConstants.MAX_LOTTO_NUMBER){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != LottoConstants.LOTTO_SIZE){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
