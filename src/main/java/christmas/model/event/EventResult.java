package christmas.model.event;

import christmas.model.price.BenefitPrice;
import christmas.model.menu.MenuAndCount;
import java.util.List;

public record EventResult(String eventName, BenefitPrice benefitPrice,
                          List<MenuAndCount> presentMenuAndCounts) {

    public Boolean isPresentMenuExists() {
        return !presentMenuAndCounts.isEmpty();
    }
}
