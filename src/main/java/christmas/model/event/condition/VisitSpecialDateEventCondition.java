package christmas.model.event.condition;

import christmas.model.calendar.EventCalendar;
import christmas.model.Order;
import christmas.model.VisitDate;

public class VisitSpecialDateEventCondition implements EventCondition {

    @Override
    public Boolean isEventApplied(Order order, VisitDate visitDate) {
        return EventCalendar.getInstance().isSpecialDay(visitDate);
    }
}
