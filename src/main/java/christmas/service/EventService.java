package christmas.service;

import christmas.model.EventResult;
import christmas.model.MenuAndCount;
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
}
