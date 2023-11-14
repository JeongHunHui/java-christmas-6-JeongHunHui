package christmas.constant.event.condition;

import christmas.model.Order;
import christmas.model.VisitDate;

public interface EventCondition {

    Boolean isEventApplied(Order order, VisitDate visitDate);
}
