package christmas.model.price;

import christmas.constant.DetailErrorMessage;
import christmas.exception.InvalidPriceException;

class PriceValidator {

    private static final Integer MIN_PRICE = 0;

    static void validateAboveMinPrice(Integer price) {
        final Boolean isBelowMinPrice = price < MIN_PRICE;
        if (isBelowMinPrice) {
            throw new InvalidPriceException(DetailErrorMessage.PRICE_CAN_NOT_BELOW_MIN_PRICE);
        }
    }
}
