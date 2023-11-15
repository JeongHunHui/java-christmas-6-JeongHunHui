package christmas.model.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuBoard {

    private static MenuBoard instance;
    private static MenuConfig menuConfig = MenuConfig.DECEMBER_2023;

    private final Map<String, Menu> menuMap;

    private MenuBoard(Map<String, Menu> menuMap) {
        this.menuMap = menuMap;
    }

    public static MenuBoard getInstance() {
        if (instance == null) {
            instance = new MenuBoard(makeMenuMap(menuConfig.getMenus()));
        }
        return instance;
    }

    private static Map<String, Menu> makeMenuMap(List<Menu> menus) {
        Map<String, Menu> menuMap = new HashMap<>();
        menus.forEach(menu -> menuMap.put(menu.getName(), menu));
        return menuMap;
    }

    public Boolean isInvalidMenuName(String name) {
        return !menuMap.containsKey(name);
    }

    public Menu getMenu(MenuName menuName) {
        return menuMap.get(menuName.menuName());
    }
}
