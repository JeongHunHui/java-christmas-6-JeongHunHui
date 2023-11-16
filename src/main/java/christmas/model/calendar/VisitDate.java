package christmas.model.calendar;

import christmas.constant.DetailErrorMessage;
import christmas.exception.InvalidVisitDateException;

public record VisitDate(Integer dayOfMonth) {

    public VisitDate {
        if (EventCalendar.getInstance().isInvalidDayOfEventMonth(dayOfMonth)) {
            throw new InvalidVisitDateException(DetailErrorMessage.VISIT_DATE_OUT_OF_RANGE);
        }
    }
}
