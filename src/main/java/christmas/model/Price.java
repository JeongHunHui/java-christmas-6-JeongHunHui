package christmas.model;

import christmas.constant.DetailErrorMessage;
import christmas.exception.InvalidPriceException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public record Price(Integer price) {

    private static final Integer MIN_PRICE = 0;
    private static final String CURRENCY_STRING = "원";
    private static final NumberFormat formatter = NumberFormat.getInstance(Locale.US);

    public Price {
        validateAboveMinPrice(price);
    }

    private void validateAboveMinPrice(Integer price) {
        final Boolean isBelowMinPrice = price < MIN_PRICE;
        if (isBelowMinPrice) {
            throw new InvalidPriceException(DetailErrorMessage.PRICE_CAN_NOT_BELOW_MIN_PRICE);
        }
    }

    public static Price getTotalPrice(List<Price> prices) {
        return new Price(prices.stream().mapToInt(Price::price).sum());
    }

    public Price getDiscountedPrice(DiscountPrice discountPrice) {
        return new Price(price - discountPrice.price());
    }

    @Override
    public String toString() {
        return formatter.format(price) + CURRENCY_STRING;
    }
}
