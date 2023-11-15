package christmas.model.event.calculator;

import christmas.model.price.BenefitPrice;
import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;
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
