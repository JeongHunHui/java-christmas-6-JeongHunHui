package christmas.service;

import christmas.constant.DetailErrorMessage;
import christmas.dto.request.OrderRequest;
import christmas.exception.InvalidOrderException;
import christmas.model.menu.Menu;
import christmas.model.menu.MenuAndCount;
import christmas.model.menu.MenuCount;
import christmas.model.order.Order;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    public Order makeOrderByRequest(OrderRequest orderRequest) {
        return new Order(makeOrderMap(orderRequest.menuAndCounts()));
    }

    private Map<Menu, MenuCount> makeOrderMap(List<MenuAndCount> menuAndCounts) {
        Map<Menu, MenuCount> orderMap = new EnumMap<>(Menu.class);

        for (MenuAndCount menuAndCount : menuAndCounts) {
            final Menu menu = menuAndCount.menu();
            if (orderMap.containsKey(menu)) {
                throw new InvalidOrderException(
                    DetailErrorMessage.ORDER_CAN_NOT_CONTAINS_DUPLICATE_MENU);
            }
            orderMap.put(menu, menuAndCount.menuCount());
        }

        return orderMap;
    }
}
