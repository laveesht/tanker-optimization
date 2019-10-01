import org.apache.commons.lang3.Range;

public class ValidationHelper {

    private static void rangeChecker(Integer start, Integer end, int testValue) {
        if (!Range.between(start, end).contains(testValue)) {
            throw new IllegalArgumentException("Input Rules:" +
                    "    The number of tankers is in range [2, 5]\n" +
                    "    A tanker's capacity is in range [2, 10000] barrels\n" +
                    "    Oil amount is in range [1, 200000] barrels\n");
        }
    }

    public static void validateInputs(TankerOptimizationTask tankerOptimizationTask) {
        rangeChecker(2, 5, tankerOptimizationTask.tankerCapacityArray.size());
        for (Integer tankerCapacity : tankerOptimizationTask.tankerCapacityArray) {
            rangeChecker(2, 10000, tankerCapacity);
        }
        rangeChecker(1, 200000, tankerOptimizationTask.oilAmount);
    }
}
