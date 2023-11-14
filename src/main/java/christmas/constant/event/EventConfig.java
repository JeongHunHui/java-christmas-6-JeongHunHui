package christmas.constant.event;

import java.util.Collections;
import java.util.List;

enum EventConfig {
    DECEMBER_2023(List.of(
        EventFactory.getChristmasDDayEvent(),
        EventFactory.getWeekdayEvent(),
        EventFactory.getWeekendEvent(),
        EventFactory.getSpecialEvent(),
        EventFactory.getPresentEvent()
    )),
    ;

    private final List<Event> events;

    EventConfig(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return Collections.unmodifiableList(events);
    }
}
