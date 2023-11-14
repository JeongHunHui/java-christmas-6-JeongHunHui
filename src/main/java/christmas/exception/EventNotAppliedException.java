package christmas.exception;

import christmas.constant.DetailErrorMessage;

public class EventNotAppliedException extends IllegalStateException {

    public EventNotAppliedException() {
        super(DetailErrorMessage.NOT_APPLIED_EVENT.message());
    }
}
