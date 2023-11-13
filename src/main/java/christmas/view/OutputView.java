package christmas.view;

import christmas.constant.PlannerMessage;

public class OutputView {

    public void writeVisitDateInputMessage() {
        write(PlannerMessage.getVisitDateInputMessage());
    }

    public void writeOrderInfoInputMessage() {
        write(PlannerMessage.getOrderInfoInputMessage());
    }

    public void writeExceptionMessage(IllegalArgumentException illegalArgumentException) {
        write(illegalArgumentException.getMessage());
    }

    private void write(String message) {
        System.out.println(message);
    }
}
