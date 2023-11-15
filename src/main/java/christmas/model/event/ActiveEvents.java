package christmas.model.event;

import christmas.model.EventResult;
import christmas.model.Order;
import christmas.model.VisitDate;
import java.util.ArrayList;
import java.util.List;

public class ActiveEvents {

    private static ActiveEvents instance;
    private static EventConfig eventConfig = EventConfig.DECEMBER_2023;

    private final List<Event> events;

    private ActiveEvents(EventConfig eventConfig) {
        this.events = eventConfig.getEvents();
    }

    public static synchronized ActiveEvents getInstance() {
        if (instance == null) {
            instance = new ActiveEvents(eventConfig);
        }
        return instance;
    }

    public List<EventResult> getAppliedEventResults(Order order, VisitDate visitDate) {
        final List<EventResult> eventResults = new ArrayList<>();
        events.stream().forEach(event -> {
            if (event.isEventApplied(order, visitDate)) {
                eventResults.add(event.getEventResult(order, visitDate));
            }
        });
        return eventResults;
    }
}
