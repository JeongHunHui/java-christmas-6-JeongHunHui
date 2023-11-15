package christmas.view.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.model.event.EventResult;
import christmas.model.event.EventResults;
import christmas.model.menu.Menu;
import christmas.model.menu.MenuAndCount;
import christmas.model.menu.MenuCount;
import christmas.model.order.Order;
import christmas.model.price.BenefitPrice;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OutputMakerTest {

    @Test
    void 주문_출력_테스트() {
        // Given: 주문 및 메뉴 설정
        Order mockOrder = mock(Order.class);
        Map<Menu, MenuCount> orderMap = new HashMap<>();
        orderMap.put(Menu.PINE_MUSHROOM_SOUP, new MenuCount(2));
        orderMap.put(Menu.CAESAR_SALAD, new MenuCount(1));
        when(mockOrder.order()).thenReturn(orderMap);

        OutputMaker outputMaker = new OutputMaker();

        // When: 주문 출력 생성
        String output = outputMaker.makeOrderOutput(mockOrder);

        // Then: 올바른 출력 형식 확인
        String expectedOutput1 = "시저샐러드 1개";
        String expectedOutput2 = "양송이수프 2개";
        assertEquals(true, output.contains(expectedOutput1));
        assertEquals(true, output.contains(expectedOutput2));
    }

    @Test
    void 선물_메뉴_출력_테스트() {
        // Given: 선물 메뉴 목록 설정
        List<MenuAndCount> presentMenuAndCounts = Arrays.asList(
            new MenuAndCount(Menu.PINE_MUSHROOM_SOUP, new MenuCount(2)),
            new MenuAndCount(Menu.CAESAR_SALAD, new MenuCount(1))
        );

        OutputMaker outputMaker = new OutputMaker();

        // When: 선물 메뉴 출력 생성
        String output = outputMaker.makePresentMenusOutput(presentMenuAndCounts);

        // Then: 올바른 출력 형식 확인
        String expectedOutput = "양송이수프 2개\n시저샐러드 1개";
        assertEquals(expectedOutput, output);
    }

    @Test
    void 이벤트_결과_출력_테스트() {
        // Given: 이벤트 결과 설정
        EventResult eventResult1 = new EventResult("크리스마스 디데이 이벤트", new BenefitPrice(2000),
            List.of());
        EventResult eventResult2 = new EventResult("특별 할인", new BenefitPrice(1000), List.of());
        EventResults eventResults = new EventResults(Arrays.asList(eventResult1, eventResult2));

        OutputMaker outputMaker = new OutputMaker();

        // When: 이벤트 결과 출력 생성
        String output = outputMaker.makeEventResultOutput(eventResults);

        // Then: 올바른 출력 형식 확인
        String expectedOutput = "크리스마스 디데이 이벤트: -2,000원\n특별 할인: -1,000원";
        assertEquals(expectedOutput, output);
    }
}
