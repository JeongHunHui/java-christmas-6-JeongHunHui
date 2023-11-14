package christmas.constant.event.condition;

import christmas.model.Order;
import christmas.model.VisitDate;

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
