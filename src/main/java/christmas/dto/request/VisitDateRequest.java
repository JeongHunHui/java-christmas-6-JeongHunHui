package christmas.dto.request;

import christmas.constant.DetailErrorMessage;
import christmas.constant.calendar.EventCalendar;
import christmas.exception.InvalidVisitDateException;

public record VisitDateRequest(Integer visitDate) {

    public VisitDateRequest {
        if (EventCalendar.getInstance().isInvalidDayOfEventMonth(visitDate)) {
            throw new InvalidVisitDateException(DetailErrorMessage.VISIT_DATE_OUT_OF_RANGE);
        }
    }
}
