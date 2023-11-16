package christmas.exception;

import christmas.constant.DetailErrorMessage;

public class InvalidMenuCountException extends InvalidValueException {

    public InvalidMenuCountException(DetailErrorMessage detailErrorMessage) {
        super(detailErrorMessage);
    }
}
