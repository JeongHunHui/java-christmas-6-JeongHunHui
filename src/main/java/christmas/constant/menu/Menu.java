package christmas.constant.menu;

public enum Menu {
    PINE_MUSHROOM_SOUP(MenuCategory.APPETIZER, "양송이수프", 6000),
    TAPAS(MenuCategory.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(MenuCategory.APPETIZER, "시저샐러드", 8000),
    T_BONE_STEAK(MenuCategory.MAIN, "티본스테이크", 55000),
    BARBECUE_RIBS(MenuCategory.MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(MenuCategory.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(MenuCategory.MAIN, "크리스마스파스타", 25000),
    CHOCOLATE_CAKE(MenuCategory.DESSERT, "초코케이크", 15000),
    ICE_CREAM(MenuCategory.DESSERT, "아이스크림", 5000),
    ZERO_COLA(MenuCategory.DRINK, "제로콜라", 3000),
    RED_WINE(MenuCategory.DRINK, "레드와인", 60000),
    CHAMPAGNE(MenuCategory.DRINK, "샴페인", 25000),
    ;

    private final MenuCategory category;
    private final String name;
    private final Integer price;

    Menu(MenuCategory category, String name, Integer price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public MenuCategory getCategory() {
        return category;
    }
}
