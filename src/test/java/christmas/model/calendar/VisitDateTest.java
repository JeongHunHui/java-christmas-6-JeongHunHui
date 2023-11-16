package christmas.model.calendar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.exception.InvalidVisitDateException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitDateTest {

    private final EventCalendar mockEventCalendar = mock(EventCalendar.class);

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 24})
    void 유효한_날짜로_생성_성공(int validDay) {
        // Given: 유효한 날짜 설정
        when(mockEventCalendar.isInvalidDayOfEventMonth(validDay)).thenReturn(false);

        // When: VisitDate 생성 시도
        // Then: 예외가 발생하지 않아야 함
        assertDoesNotThrow(() -> new VisitDate(validDay));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 32, -1})
    void 유효하지_않은_날짜로_생성_실패(int invalidDay) {
        // Given: 유효하지 않은 날짜 설정
        when(mockEventCalendar.isInvalidDayOfEventMonth(invalidDay)).thenReturn(true);

        // When: VisitDate 생성 시도
        // Then: InvalidVisitDateException 예외가 발생해야 함
        assertThrows(InvalidVisitDateException.class, () -> new VisitDate(invalidDay));
    }
}
