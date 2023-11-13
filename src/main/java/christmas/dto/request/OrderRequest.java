package christmas.dto.request;

import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuBoard;
import christmas.constant.menu.MenuCategory;
import christmas.exception.InvalidOrderException;
import christmas.model.MenuCount;
import christmas.model.OrderInfo;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OrderRequest {

    private static final Integer MAX_MENU_COUNT = 20;

    private final Map<Menu, MenuCount> order;

    public OrderRequest(List<OrderInfo> orderInfos) {
        order = new EnumMap<>(Menu.class);

        for (OrderInfo orderInfo : orderInfos) {
            Menu menu = MenuBoard.getInstance().getMenu(orderInfo.menuName());
            if (order.containsKey(menu)) {
                throw new InvalidOrderException();
            }
            MenuCount menuCount = orderInfo.menuCount();
            order.put(menu, menuCount);
        }

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
}
