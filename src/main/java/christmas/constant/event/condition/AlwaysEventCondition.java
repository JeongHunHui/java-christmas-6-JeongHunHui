package christmas.constant.event.condition;

import christmas.model.Order;
import christmas.model.VisitDate;

public class AlwaysEventCondition implements EventCondition {
    
    @Override
    public Boolean isEventApplied(Order order, VisitDate visitDate) {
        return true;
    }
}
