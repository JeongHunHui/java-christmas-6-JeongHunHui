package christmas.model.event.condition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.model.calendar.VisitDate;
import christmas.model.order.Order;
import christmas.model.price.Price;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BasicEventConditionTest {

    @ParameterizedTest
    @CsvSource({
        "1, 10, 5, 12000, true",   // 이벤트 시작일, 이벤트 종료일, 방문일, 주문 총 가격, 이벤트 적용 여부
        "1, 10, 15, 12000, false",
        "1, 10, 5, 9000, false",
        "1, 10, 15, 9000, false"
    })
    void 기본_이벤트_조건_테스트(int eventStartDate, int eventEndDate, int visitDay, int totalPrice,
        boolean expectedIsApplied) {
        // Given: 기본 이벤트 조건 설정
        BasicEventCondition condition = new BasicEventCondition(eventStartDate, eventEndDate);

        // Given: 모킹된 방문일 및 주문 설정
        VisitDate mockVisitDate = mock(VisitDate.class);
        when(mockVisitDate.dayOfMonth()).thenReturn(visitDay);
        
        Price mockPrice = mock(Price.class);
        when(mockPrice.price()).thenReturn(totalPrice);

        Order mockOrder = mock(Order.class);
        when(mockOrder.getTotalPrice()).thenReturn(mockPrice);

        // When: 이벤트 적용 조건 검사
        boolean isApplied = condition.isEventApplied(mockOrder, mockVisitDate);

        // Then: 예상된 이벤트 적용 여부 검증
        assertEquals(expectedIsApplied, isApplied);
    }
}
