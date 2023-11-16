package christmas.model.event.calculator;

import christmas.model.price.BenefitPrice;
import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;

public interface EventCalculator {

    BenefitPrice calculateBenefitPrice(Order order, VisitDate visitDate);
}
