package christmas.model.event.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.model.menu.Menu;
import christmas.model.menu.MenuAndCount;
import christmas.model.menu.MenuCount;
import christmas.model.price.BenefitPrice;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PresentEventCalculatorTest {

    @Test
    void 선물_메뉴_할인_계산_테스트() {
        // Given: 증정 메뉴로 샴페인 1개를 설정
        Integer count = 1;
        Menu menu = Menu.CHAMPAGNE;
        MenuAndCount menuAndCount = mock(MenuAndCount.class);
        MenuCount menuCount = mock(MenuCount.class);
        when(menuCount.menuCount()).thenReturn(count);
        when(menuAndCount.menu()).thenReturn(menu);
        when(menuAndCount.menuCount()).thenReturn(menuCount);
        List<MenuAndCount> presentMenuAndCounts = List.of(menuAndCount);
        PresentEventCalculator calculator = new PresentEventCalculator(presentMenuAndCounts);

        // When: 혜택 가격 계산
        BenefitPrice result = calculator.calculateBenefitPrice(null, null);

        // Then: 예상된 혜택 가격 검증
        int expectedBenefitPrice = menu.getPrice() * count;
        assertEquals(expectedBenefitPrice, result.price());
    }
}
