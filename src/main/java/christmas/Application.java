package christmas;

import christmas.controller.PlannerController;
import christmas.view.InputMapper;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputMapper inputMapper = new InputMapper();
        InputView inputView = new InputView(inputMapper);
        PlannerController plannerController = new PlannerController(outputView, inputView);
        plannerController.run();
    }
}
