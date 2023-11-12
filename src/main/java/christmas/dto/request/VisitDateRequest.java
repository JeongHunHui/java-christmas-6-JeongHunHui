package christmas.dto.request;

import christmas.exception.InvalidVisitDateException;
import christmas.validator.InputValidator;

public final class VisitDateRequest {

    private final Integer visitDate;

    private VisitDateRequest(Integer visitDate) {
        this.visitDate = visitDate;
    }

    public static VisitDateRequest fromInput(String input) {
        if (InputValidator.isNonInteger(input)) {
            throw new InvalidVisitDateException();
        }
        return new VisitDateRequest(Integer.valueOf(input));
    }

    public Integer visitDate() {
        return visitDate;
    }
}
