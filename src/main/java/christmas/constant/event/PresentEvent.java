package christmas.constant.event;

import christmas.constant.event.calculator.PresentEventCalculator;
import christmas.constant.event.condition.EventCondition;
import christmas.exception.EventNotAppliedException;
import christmas.model.EventResult;
import christmas.model.MenuAndCount;
import christmas.model.Order;
import christmas.model.VisitDate;
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
