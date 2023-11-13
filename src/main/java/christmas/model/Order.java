package christmas.model;

import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuCategory;
import christmas.exception.InvalidOrderException;
import java.util.Collections;
import java.util.Map;

public record Order(Map<Menu, MenuCount> order) {

    private static final Integer MAX_MENU_COUNT = 20;

    public Order {
        if (isTotalCountAboveMax()) {
            throw new InvalidOrderException();
        }

        if (isOrderOnlyIncludeDrink()) {
            throw new InvalidOrderException();
        }
    }

    private Boolean isOrderOnlyIncludeDrink() {
        return order.keySet().stream().allMatch(
            menu -> menu.getCategory().equals(MenuCategory.DRINK)
        );
    }

    private Boolean isTotalCountAboveMax() {
        return getTotalCount() > MAX_MENU_COUNT;
    }

    private Integer getTotalCount() {
        return order.values().stream().mapToInt(MenuCount::menuCount).sum();
    }

    @Override
    public Map<Menu, MenuCount> order() {
        return Collections.unmodifiableMap(order);
    }
}
