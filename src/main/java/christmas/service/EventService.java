package christmas.service;

import christmas.model.EventResult;
import christmas.model.MenuAndCount;
import christmas.model.Order;
import christmas.model.Price;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    public List<MenuAndCount> getPresentMenuAndCounts(List<EventResult> eventResults) {
        List<MenuAndCount> presentMenuAndCounts = new ArrayList<>();
        eventResults.stream()
            .filter(EventResult::isPresentMenuExists)
            .forEach(
                eventResult -> eventResult.presentMenuAndCounts().stream().forEach(
                    menuAndCount -> presentMenuAndCounts.add(menuAndCount)
                )
            );
        return presentMenuAndCounts;
    }

    public Price getTotalBenefitPrice(List<EventResult> eventResults) {
        return new Price(
            eventResults.stream().map(EventResult::benefitPrice).mapToInt(Price::price).sum());
    }

    public Price calculateTotalPriceAfterDiscount(Order order, List<EventResult> eventResults) {
        return new Price(order.getTotalPrice().price() - eventResults.stream()
            .filter(eventResult -> !eventResult.isPresentMenuExists())
            .map(EventResult::benefitPrice).mapToInt(Price::price).sum());
    }
}
