package christmas.model.event.condition;

import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;

public class AboveMinPriceEventCondition implements EventCondition {

    private final Integer minCriteriaPrice;

    public AboveMinPriceEventCondition(Integer minCriteriaPrice) {
        this.minCriteriaPrice = minCriteriaPrice;
    }

    @Override
    public Boolean isEventApplied(Order order, VisitDate visitDate) {
        return order.getTotalPrice().price() >= minCriteriaPrice;
    }
}
