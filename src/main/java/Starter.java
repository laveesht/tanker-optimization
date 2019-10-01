import domain.EfficientDeliveryOptimizerEngine;
import domain.TankerOptimizationTask;

import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {
        //Expected Sample Input Format :
        // (11,17,21),50
        // (2,3,5),5
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask(input);
        EfficientDeliveryOptimizerEngine engine = new EfficientDeliveryOptimizerEngine(tankerOptimizationTask);
        if (engine.getMinOilLeft() > 0) {
            // min oil we need to add
            System.out.println(engine.getMinOilLeft());
        } else {
            //print to console
            engine.getEfficientSolutionsList().forEach(es -> System.out.println(es));
        }
    }
}
