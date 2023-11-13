package christmas.constant.menu;

import christmas.model.MenuName;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MenuBoard {

    private static MenuBoard instance;

    private final Map<String, Menu> menuMap;

    private MenuBoard(Map<String, Menu> menuMap) {
        this.menuMap = menuMap;
    }

    public static MenuBoard getInstance() {
        if (instance == null) {
            instance = new MenuBoard(makeMenuMap());
        }
        return instance;
    }

    private static Map<String, Menu> makeMenuMap() {
        Map<String, Menu> menuMap = new HashMap<>();
        Arrays.stream(Menu.values()).forEach(menu -> menuMap.put(menu.getName(), menu));
        return menuMap;
    }

    public Boolean isInvalidMenuName(String name) {
        return !menuMap.containsKey(name);
    }

    public Menu getMenu(MenuName menuName) {
        return menuMap.get(menuName.menuName());
    }
}
