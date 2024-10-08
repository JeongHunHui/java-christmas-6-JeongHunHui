package christmas.model.event;

import christmas.model.order.Order;
import christmas.model.calendar.VisitDate;
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

    public EventResults getAppliedEventResults(Order order, VisitDate visitDate) {
        final List<EventResult> eventResults = new ArrayList<>();
        events.stream().forEach(event -> {
            if (event.isEventApplied(order, visitDate)) {
                eventResults.add(event.getEventResult(order, visitDate));
            }
        });
        return new EventResults(eventResults);
    }
}
