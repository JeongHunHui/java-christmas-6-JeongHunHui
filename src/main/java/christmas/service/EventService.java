package christmas.service;

import christmas.model.price.DiscountPrice;
import christmas.model.order.Order;
import christmas.model.price.Price;

public class EventService {

    public Price calculateTotalPriceAfterDiscount(Order order, DiscountPrice discountPrice) {
        return order.getTotalPrice().getDiscountedPrice(discountPrice);
    }
}
