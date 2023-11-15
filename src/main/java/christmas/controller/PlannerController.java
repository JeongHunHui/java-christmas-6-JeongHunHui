package christmas.controller;

import christmas.constant.ErrorMessage;
import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidValueException;
import christmas.model.event.EventResults;
import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;
import christmas.model.badge.ActiveEventBadges;
import christmas.model.event.ActiveEvents;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;
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
        return new VisitDate(visitDateRequest.dayOfMonth());
    }

    private Order readOrder() {
        output.writeOrderInfoInputMessage();
        return readUntilValidInput(() -> {
            OrderRequest orderRequest = input.readOrder();
            return orderService.makeOrderByRequest(orderRequest);
        }, ErrorMessage.INVALID_ORDER);
    }

    private void writeEventPreview(Order order, VisitDate visitDate) {
        final EventResults eventResults = ActiveEvents.getInstance()
            .getAppliedEventResults(order, visitDate);
        output.writeEventPreviewMessage(visitDate);
        output.writeNewLine();
        output.writeOrderMenuMessage(order);
        output.writeNewLine();
        output.writeTotalPriceBeforeDiscount(order.getTotalPrice());
        output.writeNewLine();
        output.writePresentMenus(eventResults.getPresentMenuAndCounts());
        output.writeNewLine();
        output.writeEventResult(eventResults);
        output.writeNewLine();
        output.writeTotalBenefitPrice(eventResults.getTotalBenefitPrice());
        output.writeNewLine();
        output.writeTotalPriceAfterDiscount(
            eventService.calculateTotalPriceAfterDiscount(order,
                eventResults.getTotalDiscountPrice()));
        output.writeNewLine();
        output.writeEventBadge(ActiveEventBadges.getInstance()
            .getAppliedEventBadge(eventResults.getTotalBenefitPrice()));
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
