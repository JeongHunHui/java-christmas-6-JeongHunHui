package christmas.model;

import java.util.List;

public record EventResult(String eventName, Price benefitPrice,
                          List<MenuAndCount> presentMenuAndCounts) {

    private static final Integer ZERO = 0;

    public Boolean isPresentMenuExists() {
        return presentMenuAndCounts.size() > ZERO;
    }
}
