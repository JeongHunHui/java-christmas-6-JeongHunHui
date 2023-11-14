package christmas.constant.event.calculator;

import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;

public class FixedDiscountEventCalculator implements EventCalculator {

    private final Integer discountPrice;

    public FixedDiscountEventCalculator(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public Price calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new Price(discountPrice);
    }
}
