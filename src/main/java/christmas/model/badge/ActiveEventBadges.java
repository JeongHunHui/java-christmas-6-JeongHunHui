package christmas.model.badge;

import christmas.model.price.BenefitPrice;
import java.util.List;

public class ActiveEventBadges {

    private static ActiveEventBadges instance;
    private static EventBadgeConfig eventBadgeConfig = EventBadgeConfig.DECEMBER_2023;

    private final List<EventBadge> eventBadges;

    private ActiveEventBadges(EventBadgeConfig eventBadgeConfig) {
        this.eventBadges = eventBadgeConfig.getSortedBadges();
    }

    public static synchronized ActiveEventBadges getInstance() {
        if (instance == null) {
            instance = new ActiveEventBadges(eventBadgeConfig);
        }
        return instance;
    }

    public EventBadge getAppliedEventBadge(BenefitPrice totalBenefitPrice) {
        for (EventBadge eventBadge : eventBadges) {
            if (eventBadge.isEventBadgeCanApplied(totalBenefitPrice)) {
                return eventBadge;
            }
        }
        return EventBadge.NONE;
    }
}
