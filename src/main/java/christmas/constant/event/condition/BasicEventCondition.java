package christmas.constant.event.condition;

import christmas.model.Order;
import christmas.model.VisitDate;

public class BasicEventCondition implements EventCondition {

    private final Integer eventStartDate;
    private final Integer eventEndDate;

    public BasicEventCondition(Integer eventStartDate, Integer eventEndDate) {
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }

    @Override
    public Boolean isEventApplied(Order order, VisitDate visitDate) {
        return isVisitDateInRange(visitDate);
    }

    private Boolean isVisitDateInRange(VisitDate visitDate) {
        return visitDate.visitDate() >= eventStartDate && visitDate.visitDate() <= eventEndDate;
    }
}
