package christmas.model.price;

public record DiscountPrice(Integer price) {

    public DiscountPrice {
        PriceValidator.validateAboveMinPrice(price);
    }
}
