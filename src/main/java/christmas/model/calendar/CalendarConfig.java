package christmas.model.calendar;

import java.time.Month;
import java.time.Year;
import java.util.Collections;
import java.util.List;

enum CalendarConfig {

    DECEMBER_2023(Year.of(2023), Month.DECEMBER, List.of(3, 10, 17, 24, 25, 31)),
    ;

    private final Year eventYear;
    private final Month eventMonth;
    private final List<Integer> specialDays;

    CalendarConfig(Year eventYear, Month eventMonth, List<Integer> specialDays) {
        this.eventYear = eventYear;
        this.eventMonth = eventMonth;
        this.specialDays = specialDays;
    }

    public Year eventYear() {
        return eventYear;
    }

    public Month eventMonth() {
        return eventMonth;
    }

    public List<Integer> specialDays() {
        return Collections.unmodifiableList(specialDays);
    }
}
