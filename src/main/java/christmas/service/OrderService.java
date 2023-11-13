package christmas.service;

import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuBoard;
import christmas.dto.request.OrderRequest;
import christmas.exception.InvalidOrderException;
import christmas.model.MenuCount;
import christmas.model.Order;
import christmas.model.OrderInfo;
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
                throw new InvalidOrderException();
            }
            orderMap.put(menu, orderInfo.menuCount());
        }

        return orderMap;
    }
}
