package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EfficientDeliveryOptimizerEngine {
    private final List<String> efficientSolutionsList = new ArrayList<>();
    private final int minOilLeft;

    public EfficientDeliveryOptimizerEngine(TankerOptimizationTask tankerOptimizationTask) {
        minOilLeft = find(tankerOptimizationTask.tankerCapacityArray, tankerOptimizationTask.oilAmount, "", tankerOptimizationTask.oilAmount, efficientSolutionsList);
    }

    private int find(List<Integer> tankers, int barrels, String accumulator, int minOilLeft, List<String> efficientSolutions) {
        int tankerCapacity = tankers.get(0);
        int noOfTankers = barrels / tankerCapacity; //find max instance of tanker capacity which could be used
        int oilLeft = barrels % tankerCapacity;

        if (tankers.size() == 1 || (tankerCapacity > barrels && barrels != 0)) { //optimize: if no oil left return minOil
            if (oilLeft == 0) { //tankers.size() == 1 && oilLeft == 0 , efficient solution condition
                String efficientString = accumulator.substring(1) + "," + noOfTankers;
                efficientSolutions.add(efficientString);
                minOilLeft = 0; //set minOil to 0 once any efficient solution is found
            } else if (oilLeft < minOilLeft) { //keep updating minimumOilLeft after each combination tanker capacity index
                minOilLeft = oilLeft;
            }
            return minOilLeft;
        }

        //For each tanker capacity, decement loop till noOfTankers >= 0
        //for each tanker capacity index, recurse on remaining tanker capacities to check if any combination satisfies the total oil amount
        while (noOfTankers >= 0) {
            String sol = accumulator + "," + noOfTankers; //accumulator for current tanker capacity multipliers
            //optimize: pass sublist excluding the current tankerCapacity
            //efficientSolutions -> accumulator for all solutions found
            minOilLeft = find(tankers.subList(1, tankers.size()), barrels - (noOfTankers * tankerCapacity), sol, minOilLeft, efficientSolutions);
            noOfTankers--;
        }
        return minOilLeft;
    }

    public List<String> getEfficientSolutionsList() {
        Collections.sort(efficientSolutionsList);
        return efficientSolutionsList;
    }

    public int getMinOilLeft() {
        return minOilLeft;
    }
}
