package christmas.model.event.condition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.model.order.Order;
import christmas.model.price.Price;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AboveMinPriceEventConditionTest {

    @ParameterizedTest
    @CsvSource({
        "5000, 6000, true",  // 최소 기준 가격, 주문 총 가격, 이벤트 적용 여부
        "10000, 5000, false",
        "10000, 10000, true"
    })
    void 최소_가격_이상_조건_테스트(int minCriteriaPrice, int totalPrice, boolean expectedIsApplied) {
        // Given: 최소 가격 조건 설정
        AboveMinPriceEventCondition condition = new AboveMinPriceEventCondition(minCriteriaPrice);

        // Given: 모킹된 주문 및 총 가격 설정
        Order mockOrder = mock(Order.class);
        Price totalOrderPrice = mock(Price.class);
        when(totalOrderPrice.price()).thenReturn(totalPrice);
        when(mockOrder.getTotalPrice()).thenReturn(totalOrderPrice);

        // When: 이벤트 적용 조건 검사
        boolean isApplied = condition.isEventApplied(mockOrder, null);

        // Then: 예상된 이벤트 적용 여부 검증
        assertEquals(expectedIsApplied, isApplied);
    }
}
