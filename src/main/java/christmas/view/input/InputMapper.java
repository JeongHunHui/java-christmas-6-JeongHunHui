package christmas.view.input;

import christmas.constant.DetailErrorMessage;
import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidOrderException;
import christmas.exception.InvalidVisitDateException;
import christmas.model.menu.MenuCount;
import christmas.model.menu.MenuName;
import christmas.model.order.OrderInfo;
import java.util.Arrays;
import java.util.List;

public class InputMapper {

    private static final String ORDER_DELIMITER = ",";
    private static final String MENU_COUNT_DELIMITER = "-";

    private final InputValidator inputValidator;

    public InputMapper(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public VisitDateRequest inputToVisitDateRequest(String input) {
        if (inputValidator.isNonInteger(input)) {
            throw new InvalidVisitDateException(DetailErrorMessage.VISIT_DATE_NOT_INTEGER);
        }
        return new VisitDateRequest(Integer.valueOf(input));
    }

    public OrderRequest inputToOrderRequest(String input) {
        if (inputValidator.isInvalidOrderInput(input)) {
            throw new InvalidOrderException(DetailErrorMessage.INVALID_ORDER_FORMAT);
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
