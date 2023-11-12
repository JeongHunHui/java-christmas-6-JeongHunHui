package christmas;

import christmas.controller.PlannerController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        PlannerController plannerController = new PlannerController(outputView, inputView);
        plannerController.run();
    }
}
