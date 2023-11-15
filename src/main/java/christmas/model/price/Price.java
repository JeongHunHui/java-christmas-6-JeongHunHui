package christmas.model.price;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public record Price(Integer price) {

    private static final String CURRENCY_STRING = "원";
    private static final NumberFormat formatter = NumberFormat.getInstance(Locale.US);

    public Price {
        PriceValidator.validateAboveMinPrice(price);
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
