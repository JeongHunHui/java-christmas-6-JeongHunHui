package christmas.constant;

import christmas.constant.calendar.EventCalendar;
import christmas.model.VisitDate;

public final class PlannerMessage {

    private static final String VISIT_DATE_INPUT_MESSAGE = "%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_INFO_INPUT_MESSAGE = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String EVENT_PREVIEW_MESSAGE = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";

    private PlannerMessage() {
        // 상수 클래스이므로 인스턴스 생성 방지
    }

    public static String getVisitDateInputMessage() {
        return String.format(VISIT_DATE_INPUT_MESSAGE,
            EventCalendar.getInstance().getEventMonthValue());
    }

    public static String getOrderInfoInputMessage() {
        return ORDER_INFO_INPUT_MESSAGE;
    }

    public static String getEventPreviewMessage(VisitDate visitDate) {
        return String.format(EVENT_PREVIEW_MESSAGE,
            EventCalendar.getInstance().getEventMonthValue(), visitDate.visitDate());
    }

    public static String getOrderMenuMessage() {
        return ORDER_MENU_MESSAGE;
    }
}
