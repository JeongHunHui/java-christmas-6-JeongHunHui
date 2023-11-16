package christmas.model.event.calculator;

import christmas.model.price.BenefitPrice;
import christmas.model.menu.MenuAndCount;
import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;
import christmas.model.menu.Menu;
import java.util.List;

public class PresentEventCalculator implements EventCalculator {

    private final List<MenuAndCount> presentMenuAndCounts;

    public PresentEventCalculator(List<MenuAndCount> presentMenuAndCounts) {
        this.presentMenuAndCounts = presentMenuAndCounts;
    }

    @Override
    public BenefitPrice calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new BenefitPrice(
            presentMenuAndCounts.stream().map(MenuAndCount::menu).mapToInt(Menu::getPrice).sum());
    }
}
