package christmas.model.event.calculator;

import christmas.model.BenefitPrice;
import christmas.model.Order;
import christmas.model.VisitDate;

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
