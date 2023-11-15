package christmas.model.price;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.exception.InvalidPriceException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PriceValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 1000})
    void 유효한_가격_검증(int validPrice) {
        // Given: 유효한 가격

        // When & Then: 유효한 가격에 대해서는 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> PriceValidator.validateAboveMinPrice(validPrice));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100, -1000})
    void 유효하지_않은_가격_검증(int invalidPrice) {
        // Given: 유효하지 않은 가격

        // When & Then: 유효하지 않은 가격에 대해서는 InvalidPriceException 예외가 발생해야 함
        assertThrows(InvalidPriceException.class,
            () -> PriceValidator.validateAboveMinPrice(invalidPrice));
    }
}
