package christmas.model.event.calculator;

import christmas.model.BenefitPrice;
import christmas.model.Order;
import christmas.model.VisitDate;

public interface EventCalculator {

    BenefitPrice calculateBenefitPrice(Order order, VisitDate visitDate);
}
