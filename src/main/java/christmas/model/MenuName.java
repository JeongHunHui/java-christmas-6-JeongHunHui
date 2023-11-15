package christmas.model;

import christmas.constant.DetailErrorMessage;
import christmas.model.menu.MenuBoard;
import christmas.exception.InvalidMenuNameException;

public record MenuName(String menuName) {

    public MenuName {
        if (MenuBoard.getInstance().isInvalidMenuName(menuName)) {
            throw new InvalidMenuNameException(DetailErrorMessage.MENU_NAME_NOT_IN_MENU_BOARD);
        }
    }
}
