package christmas.view;

import christmas.constant.ErrorMessage;
import christmas.constant.PlannerMessage;
import christmas.exception.InvalidValueException;
import christmas.model.MenuAndCount;
import christmas.model.Order;
import christmas.model.OrderInfo;
import christmas.model.Price;
import christmas.model.VisitDate;
import java.util.List;

public class OutputView {

    private static final String EMPTY = "";

    private OutputMaker outputMaker;

    public OutputView(OutputMaker outputMaker) {
        this.outputMaker = outputMaker;
    }

    public void writeVisitDateInputMessage() {
        write(PlannerMessage.getVisitDateInputMessage());
    }

    public void writeOrderInfoInputMessage() {
        write(PlannerMessage.getOrderInfoInputMessage());
    }

    public void writeEventPreviewMessage(VisitDate visitDate) {
        write(PlannerMessage.getEventPreviewMessage(visitDate));
    }

    public void writeOrderMenuMessage(Order order) {
        write(PlannerMessage.getOrderMenuMessage());
        write(outputMaker.makeOrderOutput(order));
    }

    public void writeTotalPriceBeforeDiscount(Price totalPrice) {
        write(PlannerMessage.getTotalPriceBeforeDiscountMessage());
        write(totalPrice.toString());
    }

    public void writePresentMenus(List<MenuAndCount> presentMenuAndCounts) {
        write(PlannerMessage.getPresentMenusMessage());
        write(outputMaker.makePresentMenusOutput(presentMenuAndCounts));
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
