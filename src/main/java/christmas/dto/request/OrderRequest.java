package christmas.dto.request;

import christmas.model.menu.MenuAndCount;
import java.util.Collections;
import java.util.List;

;

public record OrderRequest(List<MenuAndCount> menuAndCounts) {

    @Override
    public List<MenuAndCount> menuAndCounts() {
        return Collections.unmodifiableList(menuAndCounts);
    }
}
