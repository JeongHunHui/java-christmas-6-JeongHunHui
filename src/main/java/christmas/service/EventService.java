package christmas.service;

import christmas.model.DiscountPrice;
import christmas.model.Order;
import christmas.model.Price;

public class EventService {

    public Price calculateTotalPriceAfterDiscount(Order order, DiscountPrice discountPrice) {
        return order.getTotalPrice().getDiscountedPrice(discountPrice);
    }
}
