package christmas.model.event.calculator;

import christmas.model.price.BenefitPrice;
import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;

public class DDayEventCalculator implements EventCalculator {

    private final Integer defaultDiscountPrice;
    private final Integer discountPricePerDay;

    public DDayEventCalculator(Integer defaultDiscountPrice, Integer discountPricePerDay) {
        this.defaultDiscountPrice = defaultDiscountPrice;
        this.discountPricePerDay = discountPricePerDay;
    }

    @Override
    public BenefitPrice calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new BenefitPrice(defaultDiscountPrice + visitDate.dayOfMonth() * discountPricePerDay
            - discountPricePerDay);
    }
}
