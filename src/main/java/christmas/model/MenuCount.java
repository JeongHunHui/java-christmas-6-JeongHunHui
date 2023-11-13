package christmas.model;

import christmas.exception.InvalidOrderException;

public record MenuCount(Integer menuCount) {

    private static final Integer MIN_COUNT = 1;

    public MenuCount {
        if (isMenuCountOutOfRange(menuCount)) {
            throw new InvalidOrderException();
        }
    }

    private Boolean isMenuCountOutOfRange(Integer menuCount) {
        return menuCount < MIN_COUNT;
    }
}
