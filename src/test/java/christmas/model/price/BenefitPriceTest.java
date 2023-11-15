package christmas.model.price;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BenefitPriceTest {

    @ParameterizedTest
    @MethodSource("priceAndExpectedString")
    void 혜택_가격_문자열_포맷_검증(int price, String expectedString) {
        // Given: 유효한 혜택 가격
        BenefitPrice benefitPrice = new BenefitPrice(price);

        // When: 혜택 가격의 문자열 표현을 가져옴
        String priceString = benefitPrice.toString();

        // Then: 혜택 가격이 올바르게 문자열로 변환되어야 함
        assertEquals(expectedString, priceString);
    }

    static Stream<Arguments> priceAndExpectedString() {
        return Stream.of(
            Arguments.of(0, "0원"),
            Arguments.of(2000, "-2,000원"),
            Arguments.of(3000, "-3,000원")
        );
    }
}
