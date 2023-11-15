package christmas.constant.badge;

import java.util.Comparator;
import java.util.List;

public enum EventBadgeConfig {
    DECEMBER_2023(List.of(EventBadge.STAR, EventBadge.TREE, EventBadge.SANTA)),
    ;

    private final List<EventBadge> eventBadges;

    EventBadgeConfig(List<EventBadge> eventBadges) {
        this.eventBadges = eventBadges;
    }

    public List<EventBadge> getSortedBadges() {
        return eventBadges.stream()
            .sorted(Comparator.comparingInt(EventBadge::getMinCriteriaPrice).reversed())
            .toList();
    }
}
