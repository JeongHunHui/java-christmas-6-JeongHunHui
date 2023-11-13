package christmas.model;

import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuCategory;
import christmas.exception.InvalidOrderException;
import java.util.Collections;
import java.util.Map;

public record Order(Map<Menu, MenuCount> order) {

    private static final Integer MAX_MENU_COUNT = 20;

    public Order {
        if (isTotalCountAboveMax(order)) {
            throw new InvalidOrderException();
        }

        if (isOrderOnlyIncludeDrink(order)) {
            throw new InvalidOrderException();
        }
    }

    private Boolean isOrderOnlyIncludeDrink(Map<Menu, MenuCount> order) {
        return order.keySet().stream().allMatch(
            menu -> menu.getCategory().equals(MenuCategory.DRINK)
        );
    }

    private Boolean isTotalCountAboveMax(Map<Menu, MenuCount> order) {
        return getTotalCount(order) > MAX_MENU_COUNT;
    }

    private Integer getTotalCount(Map<Menu, MenuCount> order) {
        return order.values().stream().mapToInt(MenuCount::menuCount).sum();
    }

    @Override
    public Map<Menu, MenuCount> order() {
        return Collections.unmodifiableMap(order);
    }
}
