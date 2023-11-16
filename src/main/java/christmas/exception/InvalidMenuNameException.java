package christmas.exception;

import christmas.constant.DetailErrorMessage;

public class InvalidMenuNameException extends InvalidValueException {

    public InvalidMenuNameException(DetailErrorMessage detailErrorMessage) {
        super(detailErrorMessage);
    }
}
