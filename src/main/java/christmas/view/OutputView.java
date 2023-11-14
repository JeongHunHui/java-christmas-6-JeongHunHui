package christmas.view;

import christmas.constant.ErrorMessage;
import christmas.constant.PlannerMessage;
import christmas.exception.InvalidValueException;
import christmas.model.Order;
import christmas.model.VisitDate;

public class OutputView {

    private static final String EMPTY = "";

    public void writeVisitDateInputMessage() {
        write(PlannerMessage.getVisitDateInputMessage());
    }

    public void writeOrderInfoInputMessage() {
        write(PlannerMessage.getOrderInfoInputMessage());
    }

    public void writeEventPreviewMessage(VisitDate visitDate) {
        write(PlannerMessage.getEventPreviewMessage(visitDate));
    }

    public void writeOrderMenuMessage(Order order) {
        write(PlannerMessage.getOrderMenuMessage());
    }

    public void writeNewLine() {
        write(EMPTY);
    }

    public void writeExceptionMessage(ErrorMessage errorMessage, InvalidValueException e) {
        write(errorMessage.message(e.getMessage()));
    }

    private void write(String message) {
        System.out.println(message);
    }
}
