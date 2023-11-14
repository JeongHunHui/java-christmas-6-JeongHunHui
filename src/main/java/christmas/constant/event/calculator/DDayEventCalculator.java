package christmas.constant.event.calculator;

import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;

public class DDayEventCalculator implements EventCalculator {

    private final Integer discountPricePerDay;

    public DDayEventCalculator(Integer discountPricePerDay) {
        this.discountPricePerDay = discountPricePerDay;
    }

    @Override
    public Price calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new Price(visitDate.visitDate() * discountPricePerDay);
    }
}
