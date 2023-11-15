package christmas;

import christmas.controller.PlannerController;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.view.input.InputMapper;
import christmas.view.input.InputView;
import christmas.view.output.OutputMaker;
import christmas.view.output.OutputMessage;
import christmas.view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputMaker outputMaker = new OutputMaker();
        OutputMessage outputMessage = new OutputMessage();
        OutputView outputView = new OutputView(outputMaker, outputMessage);
        InputMapper inputMapper = new InputMapper();
        InputView inputView = new InputView(inputMapper);
        OrderService orderService = new OrderService();
        EventService eventService = new EventService();
        PlannerController plannerController = new PlannerController(
            outputView,
            inputView,
            orderService,
            eventService
        );
        plannerController.run();
    }
}
