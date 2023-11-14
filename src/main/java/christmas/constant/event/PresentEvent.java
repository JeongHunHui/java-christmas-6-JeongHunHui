package christmas.constant.event;

import christmas.constant.event.calculator.PresentEventCalculator;
import christmas.constant.event.condition.EventCondition;
import christmas.constant.menu.Menu;
import christmas.exception.EventNotAppliedException;
import christmas.model.EventResult;
import christmas.model.Order;
import christmas.model.VisitDate;

public class PresentEvent extends BasicEvent {

    private final Menu presentMenu;

    PresentEvent(String name, Integer eventStartDate, Integer eventEndDate,
        EventCondition condition, Menu presentMenu) {
        super(name, eventStartDate, eventEndDate, condition,
            new PresentEventCalculator(presentMenu));
        this.presentMenu = presentMenu;
    }

    @Override
    public EventResult getEventResult(Order order, VisitDate visitDate) {
        if (isEventApplied(order, visitDate)) {
            return new EventResult(name(), getEventBenefitPrice(order, visitDate), presentMenu);
        }
        throw new EventNotAppliedException();
    }
}
