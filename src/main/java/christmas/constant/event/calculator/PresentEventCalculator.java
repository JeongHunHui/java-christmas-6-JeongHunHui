package christmas.constant.event.calculator;

import christmas.constant.menu.Menu;
import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;

public class PresentEventCalculator implements EventCalculator {

    private final Menu presentMenu;

    public PresentEventCalculator(Menu presentMenu) {
        this.presentMenu = presentMenu;
    }

    @Override
    public Price calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new Price(presentMenu.getPrice());
    }
}
