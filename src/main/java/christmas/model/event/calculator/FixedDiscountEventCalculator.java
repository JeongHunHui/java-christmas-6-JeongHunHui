package christmas.model.event.calculator;

import christmas.model.price.BenefitPrice;
import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;

public class FixedDiscountEventCalculator implements EventCalculator {

    private final Integer discountPrice;

    public FixedDiscountEventCalculator(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public BenefitPrice calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new BenefitPrice(discountPrice);
    }
}
