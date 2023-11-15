package christmas.model;

import christmas.constant.DetailErrorMessage;
import christmas.model.menu.Menu;
import christmas.model.menu.MenuCategory;
import christmas.exception.InvalidOrderException;
import java.util.Collections;
import java.util.List;
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
        final Boolean isTotalCountAboveMax =
            order.values().stream().mapToInt(MenuCount::menuCount).sum() > MAX_MENU_COUNT;
        if (isTotalCountAboveMax) {
            throw new InvalidOrderException(DetailErrorMessage.TOTAL_MENU_COUNT_ABOVE_MAX);
        }
    }

    public Integer getTotalCount() {
        return order.values().stream().mapToInt(MenuCount::menuCount).sum();
    }

    public Price getTotalPrice() {
        return new Price(order.keySet().stream().mapToInt(this::calculateMenuPrice).sum());
    }

    public Integer getMenuCountByCategory(MenuCategory menuCategory) {
        return getMenuInOrderByCategory(menuCategory).stream()
            .mapToInt(menu -> order.get(menu).menuCount()).sum();
    }

    private Integer calculateMenuPrice(Menu menu) {
        return menu.getPrice() * order.get(menu).menuCount();
    }

    private List<Menu> getMenuInOrderByCategory(MenuCategory menuCategory) {
        return order.keySet().stream().filter(menu -> menu.getCategory().equals(menuCategory))
            .toList();
    }

    @Override
    public Map<Menu, MenuCount> order() {
        return Collections.unmodifiableMap(order);
    }
}
