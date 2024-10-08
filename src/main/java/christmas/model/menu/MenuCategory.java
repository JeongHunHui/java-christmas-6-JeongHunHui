package christmas.model.menu;

public enum MenuCategory {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료"),
    ;

    private final String name;

    MenuCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
