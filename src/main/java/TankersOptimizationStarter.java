import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TankersOptimizationStarter {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String input = bufferedReader.readLine().trim();
//        String input = "(11,17,21),50";
        String input = "(2,3,5),5";
        List<Integer> tankers = Stream.of(input.substring(input.indexOf("(") + 1, input.indexOf(")")).split(",")).filter(v -> !v.isEmpty()).map(v -> Integer.parseInt(v)).collect(Collectors.toList());
        int barrels = Integer.parseInt(input.split(",")[input.split(",").length - 1]);
        ValidationHelper.validateInputs(tankers, barrels);
        int minOilLeft = tankerCombination(tankers, barrels, "", barrels);
        //minOilLeft==0, atleast one efficient solution was found
        if (minOilLeft > 0) {
            // min oil we need to add
            System.out.println(tankers.get(0) - minOilLeft);
        }
    }

    private static int tankerCombination(List<Integer> tankers, int barrels, String solution, int minOilLeft) {
        int tankerCapacity = tankers.get(0);
        int noOfTankers = barrels / tankerCapacity;
        int oilLeft = barrels % tankerCapacity;

        if (tankers.size() == 1 || (tankerCapacity > barrels && barrels != 0)) {
            if (oilLeft == 0) {
                System.out.println(solution.substring(1) + "," + noOfTankers);
                minOilLeft = oilLeft;
            } else if (oilLeft < minOilLeft) {
                minOilLeft = oilLeft;
            }
            return minOilLeft;
        }

        while (noOfTankers >= 0) {
            String sol = solution + "," + noOfTankers;
            minOilLeft = tankerCombination(tankers.subList(1, tankers.size()), barrels - (noOfTankers * tankerCapacity), sol, minOilLeft);
            noOfTankers--;
        }

        return minOilLeft;
    }
}
