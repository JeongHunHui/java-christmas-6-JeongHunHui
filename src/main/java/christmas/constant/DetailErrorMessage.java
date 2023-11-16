package christmas.constant;

public enum DetailErrorMessage {
    VISIT_DATE_NOT_INTEGER("방문 날짜는 정수입니다."),
    VISIT_DATE_OUT_OF_RANGE("방문 날짜의 범위를 벗어났습니다."),
    INVALID_ORDER_FORMAT("주문의 형식이 옳지 않습니다."),
    MENU_COUNT_OUT_OF_RANGE("메뉴 수의 범위를 벗어났습니다."),
    MENU_NAME_NOT_IN_MENU_BOARD("메뉴의 이름이 메뉴판에 없습니다."),
    ORDER_CAN_NOT_CONTAINS_DUPLICATE_MENU("주문은 중복된 메뉴로 구성될 수 없습니다."),
    ORDER_ONLY_INCLUDE_DRINK("주문의 메뉴가 음료로만 구성되어 있습니다."),
    TOTAL_MENU_COUNT_ABOVE_MAX("주문 가능한 최대 메뉴 수를 초과했습니다."),
    PRICE_CAN_NOT_BELOW_MIN_PRICE("가격이 최솟값보다 낮습니다."),
    NOT_APPLIED_EVENT("적용되지 않은 이벤트입니다.");

    private final String message;

    DetailErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
