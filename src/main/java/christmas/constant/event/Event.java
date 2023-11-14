package christmas.constant.event;

import christmas.model.EventResult;
import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;

public interface Event {

    Boolean isEventApplied(Order order, VisitDate visitDate);

    Price getEventBenefitPrice(Order order, VisitDate visitDate);

    EventResult getEventResult(Order order, VisitDate visitDate);

    String name();
}
