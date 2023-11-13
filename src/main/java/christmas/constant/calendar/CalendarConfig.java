package christmas.constant.calendar;

import java.time.Month;
import java.time.Year;

enum CalendarConfig {

    DECEMBER_2023(Year.of(2023), Month.DECEMBER),
    ;

    private final Year eventYear;
    private final Month eventMonth;

    CalendarConfig(Year eventYear, Month eventMonth) {
        this.eventYear = eventYear;
        this.eventMonth = eventMonth;
    }

    public Year eventYear() {
        return eventYear;
    }

    public Month eventMonth() {
        return eventMonth;
    }
}
