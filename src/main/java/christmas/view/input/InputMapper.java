package christmas.view.input;

import christmas.constant.DetailErrorMessage;
import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
import christmas.exception.InvalidOrderException;
import christmas.exception.InvalidVisitDateException;
import christmas.model.menu.MenuAndCount;
import christmas.model.menu.MenuBoard;
import christmas.model.menu.MenuCount;
import christmas.model.menu.MenuName;
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

        return new OrderRequest(inputToMenuAndCounts(input));
    }

    private List<MenuAndCount> inputToMenuAndCounts(String input) {
        return Arrays.stream(input.split(ORDER_DELIMITER))
            .map(info -> info.split(MENU_COUNT_DELIMITER)).map(this::makeMenuAndCount).toList();
    }

    private MenuAndCount makeMenuAndCount(String[] orderInfoArray) {
        return new MenuAndCount(
            MenuBoard.getInstance().getMenu(new MenuName(orderInfoArray[0])),
            new MenuCount(Integer.valueOf(orderInfoArray[1]))
        );
    }
}
