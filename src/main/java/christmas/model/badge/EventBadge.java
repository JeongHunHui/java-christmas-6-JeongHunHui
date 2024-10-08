package christmas.model.badge;

import christmas.model.price.BenefitPrice;

public enum EventBadge {
    NONE("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    ;

    private final String name;
    private final Integer minCriteriaPrice;

    EventBadge(String name, Integer minCriteriaPrice) {
        this.name = name;
        this.minCriteriaPrice = minCriteriaPrice;
    }

    Boolean isEventBadgeCanApplied(BenefitPrice totalBenefitPrice) {
        return minCriteriaPrice <= totalBenefitPrice.price();
    }

    public String getName() {
        return name;
    }

    Integer getMinCriteriaPrice() {
        return minCriteriaPrice;
    }
}
