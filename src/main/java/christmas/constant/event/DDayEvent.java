package christmas.constant.event;

import christmas.constant.event.calculator.DDayEventCalculator;
import christmas.constant.event.condition.EventCondition;
import java.util.List;

class DDayEvent extends BasicEvent {

    public DDayEvent(String name, Integer startDate, Integer endDate,
        List<EventCondition> conditions, Integer defaultDiscountPrice,
        Integer discountPricePerDay) {
        super(name, startDate, endDate, conditions, new DDayEventCalculator(defaultDiscountPrice,
            discountPricePerDay));
    }
}
