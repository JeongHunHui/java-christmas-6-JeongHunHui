package christmas.controller;

import christmas.constant.ErrorMessage;
import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidValueException;
import christmas.model.Order;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class PlannerController {

    private final OutputView output;
    private final InputView input;
    private final OrderService orderService;

    public PlannerController(OutputView output, InputView input, OrderService orderService) {
        this.output = output;
        this.input = input;
        this.orderService = orderService;
    }

    public void run() {
        VisitDateRequest visitDateRequest = readVisitDate();
        Order orderRequest = readOrder();
    }

    public VisitDateRequest readVisitDate() {
        output.writeVisitDateInputMessage();
        return readUntilValidInput(() -> input.readVisitDate(), ErrorMessage.INVALID_VISIT_DATE);
    }

    public Order readOrder() {
        output.writeOrderInfoInputMessage();
        return readUntilValidInput(() -> {
            OrderRequest orderRequest = input.readOrder();
            return orderService.makeOrderByRequest(orderRequest);
        }, ErrorMessage.INVALID_ORDER);
    }

    private <T> T readUntilValidInput(Supplier<T> inputSupplier, ErrorMessage errorMessage) {
        T input = null;
        boolean isInValidInput = true;

        while (isInValidInput) {
            try {
                input = inputSupplier.get();
                isInValidInput = false;
            } catch (InvalidValueException e) {
                output.writeExceptionMessage(errorMessage, e);
            }
        }

        return input;
    }
}
