package christmas.constant.event.condition;

import christmas.constant.calendar.EventCalendar;
import christmas.model.Order;
import christmas.model.VisitDate;

public class VisitSpecialDateEventCondition implements EventCondition {

    @Override
    public Boolean isEventApplied(Order order, VisitDate visitDate) {
        return EventCalendar.getInstance().isSpecialDay(visitDate);
    }
}
