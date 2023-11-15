package christmas.model;

import java.util.List;

public record EventResult(String eventName, BenefitPrice benefitPrice,
                          List<MenuAndCount> presentMenuAndCounts) {

    public Boolean isPresentMenuExists() {
        return !presentMenuAndCounts.isEmpty();
    }
}
