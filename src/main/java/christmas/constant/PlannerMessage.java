package christmas.constant;

import christmas.constant.calendar.EventCalendar;

public final class PlannerMessage {

    private static final String VISIT_DATE_INPUT_MESSAGE = "%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_INFO_INPUT_MESSAGE = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

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
}
