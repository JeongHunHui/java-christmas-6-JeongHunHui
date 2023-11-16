package christmas.exception;

import christmas.constant.DetailErrorMessage;

public class InvalidOrderException extends InvalidValueException {

    public InvalidOrderException(DetailErrorMessage detailErrorMessage) {
        super(detailErrorMessage);
    }
}
