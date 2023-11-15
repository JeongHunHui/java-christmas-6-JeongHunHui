package christmas.model.order;

import christmas.model.menu.MenuCount;
import christmas.model.menu.MenuName;

public record OrderInfo(MenuName menuName, MenuCount menuCount) {

}
