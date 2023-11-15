package christmas.model.event.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.model.menu.MenuCategory;
import christmas.model.order.Order;
import christmas.model.price.BenefitPrice;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MenuCategoryCountEventCalculatorTest {

    @ParameterizedTest
    @MethodSource("provideCalculatorTestData")
    void 메뉴_카테고리별_할인_계산_테스트(MenuCategory menuCategory, int discountPricePerCount, int menuCount,
        int expectedDiscount) {
        // Given: 메뉴 카테고리 및 할인 가격 설정
        MenuCategoryCountEventCalculator calculator = new MenuCategoryCountEventCalculator(
            menuCategory, discountPricePerCount);

        // Given: 모킹된 주문과 메뉴 수 설정
        Order mockOrder = mock(Order.class);
        when(mockOrder.getMenuCountByCategory(menuCategory)).thenReturn(menuCount);

        // When: 혜택 가격 계산
        BenefitPrice result = calculator.calculateBenefitPrice(mockOrder, null);

        // Then: 예상된 혜택 가격 검증
        assertEquals(expectedDiscount, result.price());
    }

    private static Stream<Arguments> provideCalculatorTestData() {
        return Stream.of(
            Arguments.of(MenuCategory.APPETIZER, 2023, 2, 4046),
            Arguments.of(MenuCategory.MAIN, 100, 3, 300),
            Arguments.of(MenuCategory.DESSERT, 1000, 5, 5000),
            Arguments.of(MenuCategory.DRINK, 333, 3, 999)
        );
    }
}
