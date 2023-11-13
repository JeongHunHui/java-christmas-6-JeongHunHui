package christmas.view;

import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidOrderException;
import christmas.exception.InvalidVisitDateException;
import christmas.model.MenuCount;
import christmas.model.MenuName;
import christmas.model.OrderInfo;
import christmas.validator.InputValidator;
import java.util.Arrays;
import java.util.List;

public class InputMapper {

    private static final String ORDER_DELIMITER = ",";
    private static final String MENU_COUNT_DELIMITER = "-";

    public VisitDateRequest inputToVisitDateRequest(String input) {
        if (InputValidator.isNonInteger(input)) {
            throw new InvalidVisitDateException();
        }
        return new VisitDateRequest(Integer.valueOf(input));
    }

    public OrderRequest inputToOrderRequest(String input) {
        if (InputValidator.isInvalidOrderInput(input)) {
            throw new InvalidOrderException();
        }

        return new OrderRequest(inputToOrderInfos(input));
    }

    private List<OrderInfo> inputToOrderInfos(String input) {
        return Arrays.stream(input.split(ORDER_DELIMITER))
            .map(info -> info.split(MENU_COUNT_DELIMITER)).map(this::makeOrderInfo).toList();
    }

    private OrderInfo makeOrderInfo(String[] orderInfoArray) {
        return new OrderInfo(
            new MenuName(orderInfoArray[0]),
            new MenuCount(Integer.valueOf(orderInfoArray[1]))
        );
    }
}
