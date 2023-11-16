package christmas.controller;

import christmas.service.OrderService;
import christmas.view.input.InputMapper;
import christmas.view.input.InputValidator;
import christmas.view.input.InputView;
import christmas.view.output.OutputMaker;
import christmas.view.output.OutputMessage;
import christmas.view.output.OutputView;

public final class PlannerControllerFactory {

    private PlannerControllerFactory() {
        // 인스턴스 생성 방지
    }

    public static PlannerController getPlannerController() {
        OutputMaker outputMaker = new OutputMaker();
        OutputMessage outputMessage = new OutputMessage();
        OutputView outputView = new OutputView(outputMaker, outputMessage);
        InputValidator inputValidator = new InputValidator();
        InputMapper inputMapper = new InputMapper(inputValidator);
        InputView inputView = new InputView(inputMapper);
        OrderService orderService = new OrderService();
        return new PlannerController(
            outputView,
            inputView,
            orderService
        );
    }
}
