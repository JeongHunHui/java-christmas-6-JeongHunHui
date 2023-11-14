package christmas.constant.event.calculator;

import christmas.constant.menu.Menu;
import christmas.model.MenuAndCount;
import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;
import java.util.List;

public class PresentEventCalculator implements EventCalculator {

    private final List<MenuAndCount> presentMenuAndCounts;

    public PresentEventCalculator(List<MenuAndCount> presentMenuAndCounts) {
        this.presentMenuAndCounts = presentMenuAndCounts;
    }

    @Override
    public Price calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new Price(
            presentMenuAndCounts.stream().map(MenuAndCount::menu).mapToInt(Menu::getPrice).sum());
    }
}
