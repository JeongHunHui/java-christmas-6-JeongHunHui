package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.request.VisitDateRequest;

public class InputView {

    public VisitDateRequest readVisitDate() {
        return VisitDateRequest.fromInput(read());
    }

    private String read() {
        return Console.readLine();
    }
}
