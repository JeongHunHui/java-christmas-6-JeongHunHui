package christmas.constant.menu;

import java.util.Collections;
import java.util.List;

enum MenuConfig {
    DECEMBER_2023(List.of(Menu.PINE_MUSHROOM_SOUP,
        Menu.TAPAS,
        Menu.CAESAR_SALAD,
        Menu.T_BONE_STEAK,
        Menu.BARBECUE_RIBS,
        Menu.SEAFOOD_PASTA,
        Menu.CHRISTMAS_PASTA,
        Menu.CHOCOLATE_CAKE,
        Menu.ICE_CREAM,
        Menu.ZERO_COLA,
        Menu.RED_WINE,
        Menu.CHAMPAGNE)
    ),
    ;

    private final List<Menu> menus;

    MenuConfig(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }
}
