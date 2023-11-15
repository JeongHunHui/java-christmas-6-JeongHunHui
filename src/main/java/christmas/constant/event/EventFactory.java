package christmas.constant.event;

import christmas.constant.event.calculator.DDayEventCalculator;
import christmas.constant.event.calculator.FixedDiscountEventCalculator;
import christmas.constant.event.calculator.MenuCategoryCountEventCalculator;
import christmas.constant.event.condition.AboveMinPriceEventCondition;
import christmas.constant.event.condition.CategoryIncludeEventCondition;
import christmas.constant.event.condition.VisitDateDayOfWeekEventCondition;
import christmas.constant.event.condition.VisitSpecialDateEventCondition;
import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuCategory;
import christmas.model.MenuAndCount;
import christmas.model.MenuCount;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

final class EventFactory {

    private EventFactory() {
        // 인스턴스 생성 방지
    }

    static Event getChristmasDDayEvent() {
        return new BasicEvent(
            "크리스마스 디데이 할인",
            1,
            25,
            List.of(),
            new DDayEventCalculator(1000, 100)
        );
    }

    static Event getPresentEvent() {
        return new PresentEvent(
            "증정 이벤트",
            1,
            31,
            List.of(new AboveMinPriceEventCondition(120000)),
            List.of(new MenuAndCount(Menu.CHAMPAGNE, new MenuCount(1)))
        );
    }

    static Event getWeekdayEvent() {
        return new BasicEvent(
            "평일 할인",
            1,
            31,
            List.of(
                new VisitDateDayOfWeekEventCondition(
                    Set.of(DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
                        DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY)),
                new CategoryIncludeEventCondition(MenuCategory.DESSERT)
            ),
            new MenuCategoryCountEventCalculator(MenuCategory.DESSERT, 2023)
        );
    }

    static Event getWeekendEvent() {
        return new BasicEvent(
            "주말 할인",
            1,
            31,
            List.of(
                new VisitDateDayOfWeekEventCondition(
                    Set.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY)),
                new CategoryIncludeEventCondition(MenuCategory.MAIN)
            ),
            new MenuCategoryCountEventCalculator(MenuCategory.MAIN, 2023)
        );
    }

    static Event getSpecialEvent() {
        return new BasicEvent(
            "특별 할인",
            1,
            31,
            List.of(new VisitSpecialDateEventCondition()),
            new FixedDiscountEventCalculator(1000)
        );
    }
}
