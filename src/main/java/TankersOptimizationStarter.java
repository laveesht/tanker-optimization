import java.util.Scanner;

public class TankersOptimizationStarter {

    public static void main(String[] args) {
        //Expected Sample Input Format :
        // (11,17,21),50
        // (2,3,5),5
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask(input);
        new EfficientDeliveryOptimizer(tankerOptimizationTask);
    }
}
