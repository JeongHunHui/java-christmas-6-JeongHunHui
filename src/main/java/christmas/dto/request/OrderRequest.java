package christmas.dto.request;

import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuBoard;
import christmas.model.MenuCount;
import christmas.model.OrderInfo;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OrderRequest {

    private final Map<Menu, MenuCount> order;

    public OrderRequest(List<OrderInfo> orderInfos) {
        order = new EnumMap<>(Menu.class);

        for (OrderInfo orderInfo : orderInfos) {
            Menu menu = MenuBoard.getInstance().getMenu(orderInfo.menuName());
            order.put(menu, orderInfo.menuCount());
        }
    }
}
