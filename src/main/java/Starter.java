import domain.EfficientDeliveryOptimizerEngine;
import domain.TankerOptimizationTask;

import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {
        //Expected Sample Input Format :
        // (11,17,21),50
        // (2,3,5),5
        Scanner scanner = new Scanner(System.in);
        //load input line from system in
        String input = scanner.nextLine();
        //initialize a optimization task
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask(input);
        //provide optimizationtask to engine
        EfficientDeliveryOptimizerEngine engine = new EfficientDeliveryOptimizerEngine(tankerOptimizationTask);
        //if oil not fully distributed to tankers,
        // print -> minimum oil required
        //else
        //print efficient solutions found
        if (engine.getMinOilLeft() > 0) {
            System.out.println(engine.getMinOilLeft());
        } else {
            engine.getEfficientSolutionsList().forEach(es -> System.out.println(es));
        }
    }
}
