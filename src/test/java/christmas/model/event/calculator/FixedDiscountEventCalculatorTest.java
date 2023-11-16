package christmas.model.event.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.price.BenefitPrice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FixedDiscountEventCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void 고정_할인_가격_계산_테스트(int discountPrice) {
        // Given: 고정 할인 가격 설정
        FixedDiscountEventCalculator calculator = new FixedDiscountEventCalculator(discountPrice);

        // When: 혜택 가격 계산
        BenefitPrice result = calculator.calculateBenefitPrice(null, null);

        // Then: 예상된 혜택 가격 검증
        assertEquals(discountPrice, result.price());
    }
}
