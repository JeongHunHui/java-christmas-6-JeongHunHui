package christmas.exception;

import christmas.constant.ErrorMessage;

public class InvalidOrderException extends IllegalArgumentException {

    public InvalidOrderException() {
        super(ErrorMessage.INVALID_ORDER.message());
    }
}
