package christmas.model.event;

import christmas.model.price.BenefitPrice;
import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;

public interface Event {

    Boolean isEventApplied(Order order, VisitDate visitDate);

    BenefitPrice getEventBenefitPrice(Order order, VisitDate visitDate);

    EventResult getEventResult(Order order, VisitDate visitDate);

    String name();
}
