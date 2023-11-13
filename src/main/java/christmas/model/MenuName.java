package christmas.model;

import christmas.constant.menu.MenuBoard;
import christmas.exception.InvalidOrderException;

public record MenuName(String menuName) {

    public MenuName {
        if (MenuBoard.getInstance().isInvalidMenuName(menuName)) {
            throw new InvalidOrderException();
        }
    }
}
