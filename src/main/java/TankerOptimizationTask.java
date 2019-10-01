import java.util.List;

public class TankerOptimizationTask {
    public final List<Integer> tankerCapacityArray;
    public final int oilAmount;

    public TankerOptimizationTask(String inputLine) {
        this.tankerCapacityArray = Parser.parseTankerArrayString(inputLine);
        this.oilAmount = Integer.parseInt(inputLine.split(",")[inputLine.split(",").length - 1]);
        ValidationHelper.validateInputs(this);
    }
}
