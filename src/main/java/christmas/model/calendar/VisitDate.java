package christmas.model.calendar;

import christmas.constant.DetailErrorMessage;
import christmas.model.calendar.EventCalendar;
import christmas.exception.InvalidVisitDateException;

public record VisitDate(Integer visitDate) {

    public VisitDate {
        if (EventCalendar.getInstance().isInvalidDayOfEventMonth(visitDate)) {
            throw new InvalidVisitDateException(DetailErrorMessage.VISIT_DATE_OUT_OF_RANGE);
        }
    }
}
