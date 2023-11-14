package christmas.controller;

import christmas.constant.ErrorMessage;
import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidValueException;
import christmas.model.Order;
import christmas.model.VisitDate;
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
        VisitDate visitDate = readVisitDate();
        Order order = readOrder();
        writeEventPreview(order, visitDate);
    }

    private VisitDate readVisitDate() {
        output.writeVisitDateInputMessage();
        VisitDateRequest visitDateRequest = readUntilValidInput(
            () -> input.readVisitDate(), ErrorMessage.INVALID_VISIT_DATE
        );
        return new VisitDate(visitDateRequest.visitDate());
    }

    private Order readOrder() {
        output.writeOrderInfoInputMessage();
        return readUntilValidInput(() -> {
            OrderRequest orderRequest = input.readOrder();
            return orderService.makeOrderByRequest(orderRequest);
        }, ErrorMessage.INVALID_ORDER);
    }

    private void writeEventPreview(Order order, VisitDate visitDate) {
        output.writeEventPreviewMessage(visitDate);
        output.writeNewLine();
        output.writeOrderMenuMessage(order);
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
