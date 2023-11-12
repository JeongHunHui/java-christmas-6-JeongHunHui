package christmas.constant;

public enum ErrorMessage {

    INVALID_VISIT_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ;

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
    
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return String.format(ERROR_MESSAGE_FORMAT, message);
    }
}
