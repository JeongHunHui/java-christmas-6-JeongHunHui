package christmas;

import christmas.controller.PlannerController;
import christmas.controller.PlannerControllerFactory;

public class Application {

    public static void main(String[] args) {
        PlannerController plannerController = PlannerControllerFactory.getPlannerController();
        plannerController.run();
    }
}
