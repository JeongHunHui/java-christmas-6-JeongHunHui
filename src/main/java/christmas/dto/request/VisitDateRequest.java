package christmas.dto.request;

import christmas.constant.DetailErrorMessage;
import christmas.model.calendar.EventCalendar;
import christmas.exception.InvalidVisitDateException;

public record VisitDateRequest(Integer dayOfMonth) {

    public VisitDateRequest {
        if (EventCalendar.getInstance().isInvalidDayOfEventMonth(dayOfMonth)) {
            throw new InvalidVisitDateException(DetailErrorMessage.VISIT_DATE_OUT_OF_RANGE);
        }
    }
}
