package christmas.model.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuBoardTest {

    private MenuBoard menuBoard;

    @BeforeEach
    void setUp() {
        // Given: 메뉴 보드 초기화
        menuBoard = MenuBoard.getInstance();
    }

    @Test
    void 유효하지_않은_메뉴_이름_검증() {
        // Given: 유효하지 않은 메뉴 이름
        String invalidMenuName = "Invalid Menu";

        // When: 메뉴 이름 유효성 검사
        boolean isInvalid = menuBoard.isInvalidMenuName(invalidMenuName);

        // Then: 메뉴 이름은 유효하지 않아야 함
        assertTrue(isInvalid);
    }

    @Test
    void 유효한_메뉴_검색() {
        // Given: 유효한 메뉴 이름
        String validMenuName = "양송이수프";

        // When: 메뉴 검색
        Menu menu = menuBoard.getMenu(new MenuName(validMenuName));

        // Then: 유효한 메뉴가 반환되어야 함
        assertNotNull(menu);
        assertEquals(Menu.PINE_MUSHROOM_SOUP, menu);
    }
}
