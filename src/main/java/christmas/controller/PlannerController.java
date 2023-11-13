package christmas.controller;

import christmas.dto.request.OrderRequest;
import christmas.dto.request.VisitDateRequest;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Supplier;

public class PlannerController {

    private final OutputView output;
    private final InputView input;

    public PlannerController(OutputView output, InputView input) {
        this.output = output;
        this.input = input;
    }

    public void run() {
        VisitDateRequest visitDateRequest = readVisitDate();
        OrderRequest orderRequest = readOrder();
    }

    public VisitDateRequest readVisitDate() {
        output.writeVisitDateInputMessage();
        return readUntilValidInput(() -> input.readVisitDate());
    }

    public OrderRequest readOrder() {
        output.writeOrderInfoInputMessage();
        return readUntilValidInput(() -> input.readOrder());
    }

    private <T> T readUntilValidInput(Supplier<T> inputSupplier) {
        T input = null;
        boolean isInValidInput = true;

        while (isInValidInput) {
            try {
                input = inputSupplier.get();
                isInValidInput = false;
            } catch (IllegalArgumentException illegalArgumentException) {
                output.writeExceptionMessage(illegalArgumentException);
            }
        }

        return input;
    }
}
