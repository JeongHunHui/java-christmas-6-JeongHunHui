package christmas.model.event.condition;

import christmas.model.menu.MenuCategory;
import christmas.model.Order;
import christmas.model.VisitDate;

public class CategoryIncludeEventCondition implements EventCondition {

    private static final Integer ZERO = 0;

    private final MenuCategory menuCategory;

    public CategoryIncludeEventCondition(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
    }

    @Override
    public Boolean isEventApplied(Order order, VisitDate visitDate) {
        return order.getMenuCountByCategory(menuCategory) > ZERO;
    }
}
