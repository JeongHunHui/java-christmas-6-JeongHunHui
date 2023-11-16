package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;

public class InputView {

    private final InputMapper inputMapper;

    public InputView(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    public VisitDateRequest readVisitDate() {
        return inputMapper.inputToVisitDateRequest(read());
    }

    public OrderRequest readOrder() {
        return inputMapper.inputToOrderRequest(read());
    }

    private String read() {
        return Console.readLine();
    }
}
