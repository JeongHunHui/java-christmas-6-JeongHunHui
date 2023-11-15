package christmas.model.price;

import java.text.NumberFormat;
import java.util.Locale;

public record BenefitPrice(Integer price) {

    private static final Integer MINUS_ONE = -1;
    private static final String CURRENCY_STRING = "원";
    private static final NumberFormat formatter = NumberFormat.getInstance(Locale.US);

    public BenefitPrice {
        PriceValidator.validateAboveMinPrice(price);
    }

    @Override
    public String toString() {
        return formatter.format(price * MINUS_ONE) + CURRENCY_STRING;
    }
}
