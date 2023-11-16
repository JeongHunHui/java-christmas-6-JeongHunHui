package christmas.constant;

public enum InputErrorMessage {

    INVALID_VISIT_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ;

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s (%s)";

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String message(String detailErrorMessage) {
        return String.format(ERROR_MESSAGE_FORMAT, message, detailErrorMessage);
    }
}
