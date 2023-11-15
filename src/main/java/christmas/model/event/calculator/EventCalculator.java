package christmas.model.event.calculator;

import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;

public interface EventCalculator {

    Price calculateBenefitPrice(Order order, VisitDate visitDate);
}
