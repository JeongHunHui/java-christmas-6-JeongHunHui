package christmas.view;

import christmas.constant.PlannerMessage;

public class OutputView {

    public void writeVisitDateInputMessage() {
        write(PlannerMessage.getVisitDateInputMessage());
    }

    private void write(String message) {
        System.out.println(message);
    }
}
