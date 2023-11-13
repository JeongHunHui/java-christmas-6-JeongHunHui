package christmas;

import christmas.controller.PlannerController;
import christmas.service.OrderService;
import christmas.view.InputMapper;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputMapper inputMapper = new InputMapper();
        InputView inputView = new InputView(inputMapper);
        OrderService orderService = new OrderService();
        PlannerController plannerController = new PlannerController(
            outputView,
            inputView,
            orderService
        );
        plannerController.run();
    }
}
