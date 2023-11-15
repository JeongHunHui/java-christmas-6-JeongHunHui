package christmas.view.output;

import christmas.constant.ErrorMessage;
import christmas.exception.InvalidValueException;
import christmas.model.BenefitPrice;
import christmas.model.EventResults;
import christmas.model.MenuAndCount;
import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;
import christmas.model.badge.EventBadge;
import java.util.List;

public class OutputView {

    private static final String EMPTY = "";

    private final OutputMaker outputMaker;
    private final OutputMessage outputMessage;

    public OutputView(OutputMaker outputMaker, OutputMessage outputMessage) {
        this.outputMaker = outputMaker;
        this.outputMessage = outputMessage;
    }

    public void writeVisitDateInputMessage() {
        write(outputMessage.getVisitDateInputMessage());
    }

    public void writeOrderInfoInputMessage() {
        write(outputMessage.getOrderInfoInputMessage());
    }

    public void writeEventPreviewMessage(VisitDate visitDate) {
        write(outputMessage.getEventPreviewMessage(visitDate));
    }

    public void writeOrderMenuMessage(Order order) {
        write(outputMessage.getOrderMenuMessage());
        write(outputMaker.makeOrderOutput(order));
    }

    public void writeTotalPriceBeforeDiscount(Price totalPrice) {
        write(outputMessage.getTotalPriceBeforeDiscountMessage());
        write(totalPrice.toString());
    }

    public void writePresentMenus(List<MenuAndCount> presentMenuAndCounts) {
        write(outputMessage.getPresentMenusMessage());
        write(outputMaker.makePresentMenusOutput(presentMenuAndCounts));
    }

    public void writeEventResult(EventResults eventResults) {
        write(outputMessage.getEventResultMessage());
        write(outputMaker.makeEventResultOutput(eventResults));
    }

    public void writeTotalBenefitPrice(BenefitPrice totalBenefitPrice) {
        write(outputMessage.getTotalBenefitPriceMessage());
        write(totalBenefitPrice.toString());
    }

    public void writeTotalPriceAfterDiscount(Price totalPriceAfterDiscount) {
        write(outputMessage.getTotalPriceAfterDiscountMessage());
        write(totalPriceAfterDiscount.toString());
    }

    public void writeEventBadge(EventBadge appliedEventBadge) {
        write(outputMessage.getEventBadgeMessage());
        write(appliedEventBadge.getName());
    }

    public void writeNewLine() {
        write(EMPTY);
    }

    public void writeExceptionMessage(ErrorMessage errorMessage, InvalidValueException e) {
        write(errorMessage.message(e.getMessage()));
    }

    private void write(String message) {
        System.out.println(message);
    }
}
