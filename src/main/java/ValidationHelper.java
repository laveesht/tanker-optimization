import org.apache.commons.lang3.Range;

import java.util.List;

public class ValidationHelper {

    public static void validateInputs(List<Integer> tankers, int barrels) {
        rangeChecker(2, 5, tankers.size());
        for (Integer tankerCapacity : tankers) {
            rangeChecker(2, 10000, tankerCapacity);
        }
        rangeChecker(1, 200000, barrels);
    }

    private static void rangeChecker(Integer start, Integer end, int testValue) {
        if (!Range.between(start, end).contains(testValue)) {
            throw new IllegalArgumentException("Input Rules:" +
                    "    The number of tankers is in range [2, 5]\n" +
                    "    A tanker's capacity is in range [2, 10000] barrels\n" +
                    "    Oil amount is in range [1, 200000] barrels\n");
        }
    }
}
