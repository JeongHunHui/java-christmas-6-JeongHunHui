package christmas.exception;

import christmas.constant.ErrorMessage;

public class InvalidVisitDateException extends IllegalArgumentException {

    public InvalidVisitDateException() {
        super(ErrorMessage.INVALID_VISIT_DATE.message());
    }
}
