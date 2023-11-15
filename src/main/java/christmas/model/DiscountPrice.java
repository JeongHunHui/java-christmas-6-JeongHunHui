package christmas.model;

import christmas.constant.DetailErrorMessage;
import christmas.exception.InvalidPriceException;

public record DiscountPrice(Integer price) {

    private static final Integer MIN_PRICE = 0;

    public DiscountPrice {
        validateAboveMinPrice(price);
    }

    private void validateAboveMinPrice(Integer price) {
        final Boolean isBelowMinPrice = price < MIN_PRICE;
        if (isBelowMinPrice) {
            throw new InvalidPriceException(DetailErrorMessage.PRICE_CAN_NOT_BELOW_MIN_PRICE);
        }
    }
}
