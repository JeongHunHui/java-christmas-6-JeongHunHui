package christmas.model.event.calculator;

import christmas.model.BenefitPrice;
import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.model.menu.MenuCategory;

public class MenuCategoryCountEventCalculator implements EventCalculator {

    private final MenuCategory menuCategory;
    private final Integer discountPricePerCount;

    public MenuCategoryCountEventCalculator(MenuCategory menuCategory,
        Integer discountPricePerCount) {
        this.menuCategory = menuCategory;
        this.discountPricePerCount = discountPricePerCount;
    }

    @Override
    public BenefitPrice calculateBenefitPrice(Order order, VisitDate visitDate) {
        return new BenefitPrice(order.getMenuCountByCategory(menuCategory) * discountPricePerCount);
    }
}
