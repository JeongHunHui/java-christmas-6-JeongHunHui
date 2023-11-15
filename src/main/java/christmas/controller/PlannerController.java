package christmas.controller;

import christmas.constant.ErrorMessage;
import christmas.constant.event.ActiveEvents;
import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidValueException;
import christmas.model.EventResult;
import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class PlannerController {

    private final OutputView output;
    private final InputView input;
    private final OrderService orderService;
    private final EventService eventService;

    public PlannerController(OutputView output, InputView input, OrderService orderService,
        EventService eventService) {
        this.output = output;
        this.input = input;
        this.orderService = orderService;
        this.eventService = eventService;
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
        final List<EventResult> eventResults = ActiveEvents.getInstance()
            .getAppliedEventResults(order, visitDate);
        output.writeEventPreviewMessage(visitDate);
        output.writeNewLine();
        output.writeOrderMenuMessage(order);
        output.writeNewLine();
        output.writeTotalPriceBeforeDiscount(order.getTotalPrice());
        output.writeNewLine();
        output.writePresentMenus(eventService.getPresentMenuAndCounts(eventResults));
        output.writeNewLine();
        output.writeEventResult(eventResults);
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
