package christmas;

import christmas.controller.PlannerController;
import christmas.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        PlannerController plannerController = new PlannerController(outputView);
        plannerController.run();
    }
}
