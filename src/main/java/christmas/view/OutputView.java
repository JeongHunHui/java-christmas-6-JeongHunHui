package christmas.view;

import christmas.constant.ErrorMessage;
import christmas.constant.PlannerMessage;
import christmas.exception.InvalidValueException;

public class OutputView {

    public void writeVisitDateInputMessage() {
        write(PlannerMessage.getVisitDateInputMessage());
    }

    public void writeOrderInfoInputMessage() {
        write(PlannerMessage.getOrderInfoInputMessage());
    }

    public void writeExceptionMessage(ErrorMessage errorMessage, InvalidValueException e) {
        write(errorMessage.message(e.getMessage()));
    }

    private void write(String message) {
        System.out.println(message);
    }
}
