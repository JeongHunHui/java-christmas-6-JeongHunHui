package christmas.model.event.condition;

import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;

public interface EventCondition {

    Boolean isEventApplied(Order order, VisitDate visitDate);
}
