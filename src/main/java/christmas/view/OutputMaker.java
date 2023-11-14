package christmas.view;

import christmas.constant.menu.Menu;
import christmas.model.MenuAndCount;
import christmas.model.MenuCount;
import christmas.model.Order;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputMaker {

    private static final String ORDER_FORMAT = "%s %d개";
    private static final String PRESENT_MENU_FORMAT = "%s %d개";
    private static final String NEW_LINE = "\n";

    public String makeOrderOutput(Order order) {
        Map<Menu, MenuCount> orderMap = order.order();
        StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
        for (Menu menu : orderMap.keySet()) {
            MenuCount menuCount = orderMap.get(menu);
            stringJoiner.add(String.format(ORDER_FORMAT, menu.getName(), menuCount.menuCount()));
        }
        return stringJoiner.toString();
    }

    public String makePresentMenusOutput(List<MenuAndCount> presentMenuAndCounts) {
        StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
        presentMenuAndCounts.forEach(
            menuAndCount -> stringJoiner.add(
                String.format(PRESENT_MENU_FORMAT, menuAndCount.menu().getName(),
                    menuAndCount.menuCount().menuCount())));
        return stringJoiner.toString();
    }
}
