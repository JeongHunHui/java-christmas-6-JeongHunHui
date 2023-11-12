package christmas.controller;

import christmas.dto.request.VisitDateRequest;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {

    private final OutputView output;
    private final InputView input;

    public PlannerController(OutputView output, InputView input) {
        this.output = output;
        this.input = input;
    }

    public void run() {
        output.writeVisitDateInputMessage();
        VisitDateRequest visitDateRequest = input.readVisitDate();
    }
}
