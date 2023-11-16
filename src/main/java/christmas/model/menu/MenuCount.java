package christmas.model.menu;

import christmas.constant.DetailErrorMessage;
import christmas.exception.InvalidMenuCountException;

public record MenuCount(Integer menuCount) {

    private static final Integer MIN_COUNT = 1;

    public MenuCount {
        if (isMenuCountOutOfRange(menuCount)) {
            throw new InvalidMenuCountException(DetailErrorMessage.MENU_COUNT_OUT_OF_RANGE);
        }
    }

    private Boolean isMenuCountOutOfRange(Integer menuCount) {
        return menuCount < MIN_COUNT;
    }
}
