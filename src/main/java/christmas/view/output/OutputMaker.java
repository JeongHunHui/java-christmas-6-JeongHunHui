package christmas.view.output;

import christmas.model.EventResults;
import christmas.model.MenuAndCount;
import christmas.model.MenuCount;
import christmas.model.Order;
import christmas.model.menu.Menu;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputMaker {

    private static final String ORDER_FORMAT = "%s %d개";
    private static final String PRESENT_MENU_FORMAT = "%s %d개";
    private static final String PRESENT_MENU_NOT_EXIST_MESSAGE = "없음";
    private static final String EVENT_RESULT_FORMAT = "%s: %s";
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
        if (presentMenuAndCounts.isEmpty()) {
            return PRESENT_MENU_NOT_EXIST_MESSAGE;
        }
        StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
        presentMenuAndCounts.forEach(
            menuAndCount -> stringJoiner.add(
                String.format(PRESENT_MENU_FORMAT, menuAndCount.menu().getName(),
                    menuAndCount.menuCount().menuCount())));
        return stringJoiner.toString();
    }

    public String makeEventResultOutput(EventResults eventResults) {
        if (eventResults.isEmpty()) {
            return PRESENT_MENU_NOT_EXIST_MESSAGE;
        }
        StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
        eventResults.results().forEach(
            eventResult ->
                stringJoiner.add(String.format(EVENT_RESULT_FORMAT, eventResult.eventName(),
                    eventResult.benefitPrice().toString()))
        );
        return stringJoiner.toString();
    }
}
