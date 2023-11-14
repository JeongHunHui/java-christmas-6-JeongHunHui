package christmas.constant.event;

import christmas.constant.event.calculator.EventCalculator;
import christmas.constant.event.condition.BasicEventCondition;
import christmas.constant.event.condition.EventCondition;
import christmas.constant.menu.Menu;
import christmas.exception.EventNotAppliedException;
import christmas.model.EventResult;
import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;
import java.util.List;

public class BasicEvent implements Event {

    private final String name;
    private final EventCondition basicCondition;
    private final List<EventCondition> conditions;
    private final EventCalculator eventCalculator;

    BasicEvent(String name, Integer eventStartDate, Integer eventEndDate,
        List<EventCondition> conditions, EventCalculator eventCalculator) {
        this.name = name;
        this.basicCondition = new BasicEventCondition(eventStartDate, eventEndDate);
        this.conditions = conditions;
        this.eventCalculator = eventCalculator;
    }

    @Override
    public Boolean isEventApplied(Order order, VisitDate visitDate) {
        return basicCondition.isEventApplied(order, visitDate) && conditions.stream()
            .allMatch(condition -> condition.isEventApplied(order, visitDate));
    }

    @Override
    public Price getEventBenefitPrice(Order order, VisitDate visitDate) {
        return eventCalculator.calculateBenefitPrice(order, visitDate);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public EventResult getEventResult(Order order, VisitDate visitDate) {
        if (isEventApplied(order, visitDate)) {
            return new EventResult(name, getEventBenefitPrice(order, visitDate), Menu.NONE);
        }
        throw new EventNotAppliedException();
    }
}
