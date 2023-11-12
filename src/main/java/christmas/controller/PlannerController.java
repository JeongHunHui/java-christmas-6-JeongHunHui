package christmas.controller;

import christmas.view.OutputView;

public class PlannerController {

    private final OutputView output;

    public PlannerController(OutputView output) {
        this.output = output;
    }

    public void run() {
        output.writeVisitDateInputMessage();
    }
}
