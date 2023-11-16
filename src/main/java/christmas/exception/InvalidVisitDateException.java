package christmas.exception;

import christmas.constant.DetailErrorMessage;

public class InvalidVisitDateException extends InvalidValueException {

    public InvalidVisitDateException(DetailErrorMessage detailErrorMessage) {
        super(detailErrorMessage);
    }
}
