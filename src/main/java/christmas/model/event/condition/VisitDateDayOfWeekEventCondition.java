package christmas.model.event.condition;

import christmas.model.calendar.EventCalendar;
import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;
import java.time.DayOfWeek;
import java.util.Set;

public class VisitDateDayOfWeekEventCondition implements EventCondition {

    private final Set<DayOfWeek> dayOfWeekSet;

    public VisitDateDayOfWeekEventCondition(Set<DayOfWeek> dayOfWeekSet) {
        this.dayOfWeekSet = dayOfWeekSet;
    }

    @Override
    public Boolean isEventApplied(Order order, VisitDate visitDate) {
        return dayOfWeekSet.contains(EventCalendar.getInstance().getEventDayOfWeek(visitDate));
    }
}
