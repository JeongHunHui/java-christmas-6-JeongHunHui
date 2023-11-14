package christmas.constant.calendar;

import christmas.model.VisitDate;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class EventCalendar {

    private static EventCalendar instance;
    private static CalendarConfig calendarConfig = CalendarConfig.DECEMBER_2023;
    private static final Integer START_DAT_OF_MONTH = 1;

    private final Year eventYear;
    private final Month eventMonth;

    private EventCalendar(CalendarConfig calendarConfig) {
        this.eventYear = calendarConfig.eventYear();
        this.eventMonth = calendarConfig.eventMonth();
    }

    public static synchronized EventCalendar getInstance() {
        if (instance == null) {
            instance = new EventCalendar(calendarConfig);
        }
        return instance;
    }

    public Boolean isInvalidDayOfEventMonth(Integer dayOfMonth) {
        return dayOfMonth < START_DAT_OF_MONTH || dayOfMonth > eventMonth.length(
            eventYear.isLeap());
    }

    public Integer getEventMonthValue() {
        return eventMonth.getValue();
    }

    public DayOfWeek getEventDayOfWeek(VisitDate visitDate) {
        return LocalDate.of(eventYear.getValue(), eventMonth, visitDate.visitDate()).getDayOfWeek();
    }
}
