package christmas.service;

import christmas.constant.DetailErrorMessage;
import christmas.model.menu.Menu;
import christmas.model.menu.MenuBoard;
import christmas.dto.request.OrderRequest;
import christmas.exception.InvalidOrderException;
import christmas.model.menu.MenuCount;
import christmas.model.order.Order;
import christmas.model.order.OrderInfo;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    public Order makeOrderByRequest(OrderRequest orderRequest) {
        return new Order(makeOrderMap(orderRequest.orderInfos()));
    }

    private Map<Menu, MenuCount> makeOrderMap(List<OrderInfo> orderInfos) {
        Map<Menu, MenuCount> orderMap = new EnumMap<>(Menu.class);

        for (OrderInfo orderInfo : orderInfos) {
            final Menu menu = MenuBoard.getInstance().getMenu(orderInfo.menuName());
            if (orderMap.containsKey(menu)) {
                throw new InvalidOrderException(
                    DetailErrorMessage.ORDER_CAN_NOT_CONTAINS_DUPLICATE_MENU);
            }
            orderMap.put(menu, orderInfo.menuCount());
        }

        return orderMap;
    }
}
