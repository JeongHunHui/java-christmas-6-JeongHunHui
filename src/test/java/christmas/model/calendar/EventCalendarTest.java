package christmas.model.calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.DayOfWeek;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class EventCalendarTest {

    private final EventCalendar eventCalendar = EventCalendar.getInstance();

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 31})
    void 유효한_날짜_검증(int validDay) {
        // Given: 유효한 날짜가 주어지고
        // When: 날짜가 유효하지 않은지 확인하면
        Boolean isInvalid = eventCalendar.isInvalidDayOfEventMonth(validDay);

        // Then: 날짜가 유효하다.
        assertFalse(isInvalid);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 32, -1})
    void 유효하지_않은_날짜_검증(int invalidDay) {
        // Given: 유효하지 않은 날짜가 주어지고
        // When: 날짜가 유효하지 않은지 확인하면
        boolean isInvalid = eventCalendar.isInvalidDayOfEventMonth(invalidDay);

        // Boolean: 날짜가 유효하지 않다.
        assertTrue(isInvalid);
    }

    @ParameterizedTest
    @MethodSource("dayOfWeekAndDayOfMonthProvider")
    void 특정_날짜의_요일_검증(int dayOfMonth, DayOfWeek dayOfWeek) {
        // Given: 특정 날짜 설정
        VisitDate date = mock(VisitDate.class);
        when(date.dayOfMonth()).thenReturn(dayOfMonth);

        // When: 날짜에 해당하는 요일 가져오기
        DayOfWeek actualDayOfWeek = eventCalendar.getEventDayOfWeek(date);

        // Then: 예상 요일과 실제 요일 일치 검증
        assertEquals(dayOfWeek, actualDayOfWeek);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 25, 31})
    void 특별한_날_검증(int specialDay) {
        // Given: 특별한 날짜 설정
        VisitDate specialDate = mock(VisitDate.class);
        when(specialDate.dayOfMonth()).thenReturn(specialDay);

        // When: 날짜가 특별한지 검사
        boolean isSpecial = eventCalendar.isSpecialDay(specialDate);

        // Then: 특별한 날짜 검증
        assertTrue(isSpecial);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 29})
    void 특별하지_않은_날_검증(int normalDay) {
        // Given: 특별하지 않은 날짜 설정
        VisitDate normalDate = mock(VisitDate.class);
        when(normalDate.dayOfMonth()).thenReturn(normalDay);

        // When: 날짜가 특별한지 검사
        boolean isSpecial = eventCalendar.isSpecialDay(normalDate);

        // Then: 일반 날짜 검증
        assertFalse(isSpecial);
    }

    static Stream<Arguments> dayOfWeekAndDayOfMonthProvider() {
        return Stream.of(
            Arguments.of(1, DayOfWeek.FRIDAY),
            Arguments.of(13, DayOfWeek.WEDNESDAY)
        );
    }
}
