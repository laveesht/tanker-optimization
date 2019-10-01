import java.util.List;
import java.util.Scanner;

public class TankersOptimizationStarter {

    public static void main(String[] args) {
        //Expected Sample Input Format :
        // (11,17,21),50
        // (2,3,5),5
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> tankers = Parser.parseTankerArrayString(input);
        int barrels = Integer.parseInt(input.split(",")[input.split(",").length - 1]);
        ValidationHelper.validateInputs(tankers, barrels);
        EfficientDeliveryOptimizer.find(tankers, barrels);
    }
}
