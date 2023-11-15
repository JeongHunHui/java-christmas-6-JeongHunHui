package christmas.model.event;

import christmas.model.price.BenefitPrice;
import christmas.model.price.DiscountPrice;
import christmas.model.menu.MenuAndCount;
import java.util.Collections;
import java.util.List;

public record EventResults(List<EventResult> results) {

    public List<MenuAndCount> getPresentMenuAndCounts() {
        return results.stream()
            .filter(EventResult::isPresentMenuExists)
            .flatMap(eventResult -> eventResult.presentMenuAndCounts().stream())
            .toList();
    }

    public BenefitPrice getTotalBenefitPrice() {
        return new BenefitPrice(
            results.stream()
                .map(EventResult::benefitPrice)
                .mapToInt(BenefitPrice::price)
                .sum()
        );
    }

    public DiscountPrice getTotalDiscountPrice() {
        return new DiscountPrice(
            results.stream()
                .filter(result -> !result.isPresentMenuExists())
                .map(EventResult::benefitPrice)
                .mapToInt(BenefitPrice::price)
                .sum()
        );
    }

    public Boolean isEmpty() {
        return results.isEmpty();
    }

    @Override
    public List<EventResult> results() {
        return Collections.unmodifiableList(results);
    }
}
