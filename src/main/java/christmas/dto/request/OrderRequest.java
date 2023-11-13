package christmas.dto.request;

import christmas.model.OrderInfo;
import java.util.Collections;
import java.util.List;

public record OrderRequest(List<OrderInfo> orderInfos) {

    @Override
    public List<OrderInfo> orderInfos() {
        return Collections.unmodifiableList(orderInfos);
    }
}
