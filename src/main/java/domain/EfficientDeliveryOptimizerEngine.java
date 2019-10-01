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
        int noOfTankers = barrels / tankerCapacity;
        int oilLeft = barrels % tankerCapacity;

        if (tankers.size() == 1 || (tankerCapacity > barrels && barrels != 0)) {
            if (oilLeft == 0) {
                String efficientString = accumulator.substring(1) + "," + noOfTankers;
                efficientSolutions.add(efficientString);
                minOilLeft = oilLeft;
            } else if (oilLeft < minOilLeft) {
                minOilLeft = oilLeft;
            }
            return minOilLeft;
        }

        while (noOfTankers >= 0) {
            String sol = accumulator + "," + noOfTankers;
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
