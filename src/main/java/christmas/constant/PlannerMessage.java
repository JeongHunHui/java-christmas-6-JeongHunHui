package christmas.constant;

public final class PlannerMessage {

    private static final String VISIT_DATE_INPUT_MESSAGE = "%s월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private PlannerMessage() {
        // 상수 클래스이므로 인스턴스 생성 방지
    }

    public static String getVisitDateInputMessage() {
        return String.format(VISIT_DATE_INPUT_MESSAGE, PlannerConstant.EVENT_MONTH);
    }
}
