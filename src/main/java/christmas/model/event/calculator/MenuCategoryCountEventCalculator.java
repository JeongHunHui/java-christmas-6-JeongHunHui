package christmas.model.event.calculator;

import christmas.model.menu.MenuCategory;
import christmas.model.Order;
import christmas.model.Price;
import christmas.model.VisitDate;

public class MenuCategoryCountEventCalculator implements EventCalculator {

    private final MenuCategory menuCategory;
    private final Integer discountPricePerCount;

    public MenuCategoryCountEventCalculator(MenuCategory menuCategory,
        Integer discountPricePerCount) {
        this.menuCategory = menuCategory;
        this.discountPricePerCount = discountPricePerCount;
    }

    @Override
    public Price calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new Price(order.getMenuCountByCategory(menuCategory) * discountPricePerCount);
    }
}
