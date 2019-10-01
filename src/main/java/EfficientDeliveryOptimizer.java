import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class EfficientDeliveryOptimizer {

    public static void find(List<Integer> tankers, int barrels) {
        List<String> efficientSolutionsList = new ArrayList<>();
        int minOilLeft = find(tankers, barrels, "", barrels, efficientSolutionsList);
        if (minOilLeft > 0) {
            // min oil we need to add
            out.println("Efficient Deliveries oil needed::" + (tankers.get(0) - minOilLeft));
        } else {
            out.println("Efficient Deliveries variations::");
            //Sort efficient deliveries
            Collections.sort(efficientSolutionsList);
            //print to console
            efficientSolutionsList.forEach(es -> out.println(es));
        }
    }

    private static int find(List<Integer> tankers, int barrels, String accumulator, int minOilLeft, List<String> efficientSolutions) {
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
}
