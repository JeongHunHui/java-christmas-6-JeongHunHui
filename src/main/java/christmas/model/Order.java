package christmas.model;

import christmas.constant.DetailErrorMessage;
import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuCategory;
import christmas.exception.InvalidOrderException;
import java.util.Collections;
import java.util.Map;

public record Order(Map<Menu, MenuCount> order) {

    private static final Integer MAX_MENU_COUNT = 20;

    public Order {
        validateOrderNotOnlyIncludeDrink(order);
        validateOrderTotalCountBelowMax(order);
    }

    private void validateOrderNotOnlyIncludeDrink(Map<Menu, MenuCount> order) {
        final Boolean isOrderOnlyIncludeDrink = order.keySet().stream().allMatch(
            menu -> menu.getCategory().equals(MenuCategory.DRINK)
        );
        if (isOrderOnlyIncludeDrink) {
            throw new InvalidOrderException(DetailErrorMessage.ORDER_ONLY_INCLUDE_DRINK);
        }
    }

    private void validateOrderTotalCountBelowMax(Map<Menu, MenuCount> order) {
        final Boolean isTotalCountAboveMax = getTotalCount(order) > MAX_MENU_COUNT;
        if (isTotalCountAboveMax) {
            throw new InvalidOrderException(DetailErrorMessage.TOTAL_MENU_COUNT_ABOVE_MAX);
        }
    }

    private Integer getTotalCount(Map<Menu, MenuCount> order) {
        return order.values().stream().mapToInt(MenuCount::menuCount).sum();
    }

    @Override
    public Map<Menu, MenuCount> order() {
        return Collections.unmodifiableMap(order);
    }
}
