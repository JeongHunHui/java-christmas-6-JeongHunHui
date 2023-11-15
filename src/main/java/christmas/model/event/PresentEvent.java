package christmas.model.event;

import christmas.model.event.calculator.PresentEventCalculator;
import christmas.model.event.condition.EventCondition;
import christmas.exception.EventNotAppliedException;
import christmas.model.menu.MenuAndCount;
import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;
import java.util.List;

public class PresentEvent extends BasicEvent {

    private final List<MenuAndCount> presentMenuAndCounts;

    PresentEvent(String name, Integer eventStartDate, Integer eventEndDate,
        List<EventCondition> conditions, List<MenuAndCount> presentMenuAndCounts) {
        super(name, eventStartDate, eventEndDate, conditions,
            new PresentEventCalculator(presentMenuAndCounts));
        this.presentMenuAndCounts = presentMenuAndCounts;
    }

    @Override
    public EventResult getEventResult(Order order, VisitDate visitDate) {
        if (isEventApplied(order, visitDate)) {
            return new EventResult(name(), getEventBenefitPrice(order, visitDate),
                presentMenuAndCounts);
        }
        throw new EventNotAppliedException();
    }
}
