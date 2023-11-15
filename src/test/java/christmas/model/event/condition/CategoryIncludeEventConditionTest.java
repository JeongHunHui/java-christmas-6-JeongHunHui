package christmas.model.event.condition;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.model.menu.MenuCategory;
import christmas.model.order.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class CategoryIncludeEventConditionTest {

    @ParameterizedTest
    @EnumSource(MenuCategory.class)
    void 카테고리_포함_이벤트_조건_테스트(MenuCategory menuCategory) {
        // Given: 카테고리 포함 이벤트 조건 설정
        CategoryIncludeEventCondition condition = new CategoryIncludeEventCondition(menuCategory);

        // Given: 모킹된 주문 설정
        Order mockOrder = mock(Order.class);
        when(mockOrder.getMenuCountByCategory(menuCategory)).thenReturn(1); // 카테고리에 하나의 메뉴 가정

        // When: 이벤트 적용 조건 검사
        boolean isApplied = condition.isEventApplied(mockOrder, null);

        // Then: 해당 카테고리가 주문에 포함되어 있으므로 이벤트 적용 조건은 참이어야 함
        assertTrue(isApplied);
    }

    @ParameterizedTest
    @EnumSource(MenuCategory.class)
    void 카테고리_미포함_이벤트_조건_테스트(MenuCategory menuCategory) {
        // Given: 카테고리 포함 이벤트 조건 설정
        CategoryIncludeEventCondition condition = new CategoryIncludeEventCondition(menuCategory);

        // Given: 모킹된 주문 설정
        Order mockOrder = mock(Order.class);
        when(mockOrder.getMenuCountByCategory(menuCategory)).thenReturn(0); // 카테고리에 메뉴가 없음

        // When: 이벤트 적용 조건 검사
        boolean isApplied = condition.isEventApplied(mockOrder, null);

        // Then: 해당 카테고리가 주문에 포함되어 있지 않으므로 이벤트 적용 조건은 거짓이어야 함
        assertFalse(isApplied);
    }
}
