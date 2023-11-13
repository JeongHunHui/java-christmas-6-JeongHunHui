package christmas.controller;

import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
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
        return readUntilValidInput(() -> input.readVisitDate());
    }

    public Order readOrder() {
        output.writeOrderInfoInputMessage();
        return readUntilValidInput(() -> {
            OrderRequest orderRequest = input.readOrder();
            return orderService.makeOrderByRequest(orderRequest);
        });
    }

    private <T> T readUntilValidInput(Supplier<T> inputSupplier) {
        T input = null;
        boolean isInValidInput = true;

        while (isInValidInput) {
            try {
                input = inputSupplier.get();
                isInValidInput = false;
            } catch (IllegalArgumentException illegalArgumentException) {
                output.writeExceptionMessage(illegalArgumentException);
            }
        }

        return input;
    }
}
