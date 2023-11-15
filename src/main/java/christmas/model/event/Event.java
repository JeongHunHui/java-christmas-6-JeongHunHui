package christmas.model.event;

import christmas.model.BenefitPrice;
import christmas.model.EventResult;
import christmas.model.Order;
import christmas.model.VisitDate;

public interface Event {

    Boolean isEventApplied(Order order, VisitDate visitDate);

    BenefitPrice getEventBenefitPrice(Order order, VisitDate visitDate);

    EventResult getEventResult(Order order, VisitDate visitDate);

    String name();
}
