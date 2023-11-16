package christmas.model.event.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.model.calendar.VisitDate;
import christmas.model.price.BenefitPrice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DDayEventCalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "1000, 100, 1, 1000",  // 기본 할인가격, 일별 할인가격, 방문 일자, 예상 할인가격
        "1000, 100, 10, 1900",
        "500, 50, 5, 700"
    })
    void 디데이_이벤트_계산기_테스트(int defaultDiscountPrice, int discountPricePerDay, int dayOfMonth,
        int expectedDiscount) {
        // Given: 디데이 이벤트 계산기와 모킹된 방문 날짜 설정
        DDayEventCalculator calculator = new DDayEventCalculator(defaultDiscountPrice,
            discountPricePerDay);
        VisitDate mockVisitDate = mock(VisitDate.class);
        when(mockVisitDate.dayOfMonth()).thenReturn(dayOfMonth);

        // When: 혜택 가격 계산
        BenefitPrice result = calculator.calculateBenefitPrice(null, mockVisitDate);

        // Then: 예상된 혜택 가격 검증
        assertEquals(expectedDiscount, result.price());
    }
}
