package christmas.model.event.calculator;

import christmas.model.BenefitPrice;
import christmas.model.Order;
import christmas.model.VisitDate;

public class DDayEventCalculator implements EventCalculator {

    private final Integer defaultDiscountPrice;
    private final Integer discountPricePerDay;

    public DDayEventCalculator(Integer defaultDiscountPrice, Integer discountPricePerDay) {
        this.defaultDiscountPrice = defaultDiscountPrice;
        this.discountPricePerDay = discountPricePerDay;
    }

    @Override
    public BenefitPrice calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new BenefitPrice(defaultDiscountPrice + visitDate.visitDate() * discountPricePerDay
            - discountPricePerDay);
    }
}
