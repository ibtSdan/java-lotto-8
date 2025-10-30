package message;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어있습니다."),
    NOT_POSITIVE("구입 금액은 양수여야 합니다."),
    LARGE_INPUT("입력값이 너무 큽니다."),
    NOT_MULTIPLE_OF_THOUSAND("구입 금액은 1,000원 단위어야 합니다."),
    INVALID_WINNING_NUMBER_COUNT("당첨 숫자는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 숫자는 1이상 45이하의 정수여야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 숫자는 당첨 숫자와 중복될 수 없습니다."),
    LOTTO_NUMBER_DUPLICATE("로또 번호는 중복이 될 수 없습니다."),
    ;

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return "[ERROR]: " + message;
    }
}
