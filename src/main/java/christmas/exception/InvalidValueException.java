package christmas.exception;

import christmas.constant.DetailErrorMessage;

public class InvalidValueException extends IllegalArgumentException {

    public InvalidValueException(DetailErrorMessage detailErrorMessage) {
        super(detailErrorMessage.message());
    }
}
