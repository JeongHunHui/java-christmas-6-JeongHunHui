package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidVisitDateException;
import christmas.validator.InputValidator;

public class InputView {

    public VisitDateRequest readVisitDate() {
        String input = read();
        if (InputValidator.isNonInteger(input)) {
            throw new InvalidVisitDateException();
        }
        return new VisitDateRequest(Integer.valueOf(input));
    }

    private String read() {
        return Console.readLine();
    }
}
