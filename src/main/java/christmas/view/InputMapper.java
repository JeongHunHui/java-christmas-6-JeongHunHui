package christmas.view;

import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidVisitDateException;
import christmas.validator.InputValidator;

public class InputMapper {

    public VisitDateRequest inputToVisitDateRequest(String input) {
        if (InputValidator.isNonInteger(input)) {
            throw new InvalidVisitDateException();
        }
        return new VisitDateRequest(Integer.valueOf(input));
    }
}
