package christmas.exception;

import christmas.constant.DetailErrorMessage;

public class InvalidPriceException extends InvalidValueException {

    public InvalidPriceException(DetailErrorMessage detailErrorMessage) {
        super(detailErrorMessage);
    }
}
