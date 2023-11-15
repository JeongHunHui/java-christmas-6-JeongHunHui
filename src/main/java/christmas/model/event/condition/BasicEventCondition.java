package christmas.model.event.condition;

import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;

public class BasicEventCondition implements EventCondition {

    private static final Integer MIN_CRITERIA_PRICE = 10000;

    private final Integer eventStartDate;
    private final Integer eventEndDate;

    public BasicEventCondition(Integer eventStartDate, Integer eventEndDate) {
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }

    @Override
    public Boolean isEventApplied(Order order, VisitDate visitDate) {
        return isVisitDateInRange(visitDate) && isTotalPriceInRange(order.getTotalPrice());
    }

    private Boolean isVisitDateInRange(VisitDate visitDate) {
        return visitDate.visitDate() >= eventStartDate && visitDate.visitDate() <= eventEndDate;
    }

    private Boolean isTotalPriceInRange(Price totalPrice) {
        return totalPrice.price() >= MIN_CRITERIA_PRICE;
    }
}
