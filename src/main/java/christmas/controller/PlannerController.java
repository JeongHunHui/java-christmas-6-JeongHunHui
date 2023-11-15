package christmas.controller;

import christmas.constant.InputErrorMessage;
import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidValueException;
import christmas.model.badge.ActiveEventBadges;
import christmas.model.calendar.VisitDate;
import christmas.model.event.ActiveEvents;
import christmas.model.event.EventResults;
import christmas.model.order.Order;
import christmas.model.price.BenefitPrice;
import christmas.model.price.DiscountPrice;
import christmas.model.price.Price;
import christmas.service.OrderService;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;
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
        final VisitDate visitDate = readVisitDate();
        final Order order = readOrder();
        writeEventPreview(order, visitDate);
    }

    private VisitDate readVisitDate() {
        output.writeVisitDateInputMessage();
        VisitDateRequest visitDateRequest = readUntilValidInput(
            () -> input.readVisitDate(), InputErrorMessage.INVALID_VISIT_DATE
        );
        return new VisitDate(visitDateRequest.dayOfMonth());
    }

    private Order readOrder() {
        output.writeOrderInfoInputMessage();
        return readUntilValidInput(() -> {
            OrderRequest orderRequest = input.readOrder();
            return orderService.makeOrderByRequest(orderRequest);
        }, InputErrorMessage.INVALID_ORDER);
    }

    private void writeEventPreview(Order order, VisitDate visitDate) {
        final EventResults eventResults = ActiveEvents.getInstance()
            .getAppliedEventResults(order, visitDate);
        final Price totalPriceBeforeDiscount = order.getTotalPrice();
        final BenefitPrice totalBenefitPrice = eventResults.getTotalBenefitPrice();
        final DiscountPrice totalDiscountPrice = eventResults.getTotalDiscountPrice();

        output.writeEventPreviewMessage(visitDate);
        output.writeOrderMenuMessage(order);
        output.writeTotalPriceBeforeDiscount(totalPriceBeforeDiscount);
        output.writePresentMenus(eventResults.getPresentMenuAndCounts());
        output.writeEventResult(eventResults);
        output.writeTotalBenefitPrice(totalBenefitPrice);
        output.writeTotalPriceAfterDiscount(
            totalPriceBeforeDiscount.getDiscountedPrice(totalDiscountPrice)
        );
        output.writeEventBadge(
            ActiveEventBadges.getInstance().getAppliedEventBadge(totalBenefitPrice)
        );
    }

    private <T> T readUntilValidInput(Supplier<T> inputSupplier,
        InputErrorMessage inputErrorMessage) {
        T input = null;
        boolean isInValidInput = true;

        while (isInValidInput) {
            try {
                input = inputSupplier.get();
                isInValidInput = false;
            } catch (InvalidValueException e) {
                output.writeExceptionMessage(inputErrorMessage, e);
            }
        }

        return input;
    }
}
