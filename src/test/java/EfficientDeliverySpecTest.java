import domain.EfficientDeliveryOptimizerEngine;
import domain.TankerOptimizationTask;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EfficientDeliverySpecTest {

    @Test
    public void correctlyParsesInput() {
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask("(2,3,5),5");
        assertEquals(5, tankerOptimizationTask.oilAmount);
        assertEquals(Arrays.asList(2, 3, 5), tankerOptimizationTask.tankerCapacityArray);
    }

    @Test
    public void efficientSolution() {
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask("(2,3,5),5");
        EfficientDeliveryOptimizerEngine efficientDeliveryOptimizerEngine = new EfficientDeliveryOptimizerEngine(tankerOptimizationTask);
        assertEquals(2, efficientDeliveryOptimizerEngine.getEfficientSolutionsList().size());
        assertEquals("0,0,1", efficientDeliveryOptimizerEngine.getEfficientSolutionsList().get(0));
        assertEquals("1,1,0", efficientDeliveryOptimizerEngine.getEfficientSolutionsList().get(1));
    }

    @Test
    public void noEfficientSolution() {
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask("(2,7,11),5");
        EfficientDeliveryOptimizerEngine efficientDeliveryOptimizerEngine = new EfficientDeliveryOptimizerEngine(tankerOptimizationTask);
        assertEquals(0, efficientDeliveryOptimizerEngine.getEfficientSolutionsList().size());
        assertEquals(1, efficientDeliveryOptimizerEngine.getMinOilLeft());
    }

    @Test
    public void oilLessThanTankerCapacity() {
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask("(2,7,11),1");
        EfficientDeliveryOptimizerEngine efficientDeliveryOptimizerEngine = new EfficientDeliveryOptimizerEngine(tankerOptimizationTask);
        assertEquals(0, efficientDeliveryOptimizerEngine.getEfficientSolutionsList().size());
        assertEquals(1, efficientDeliveryOptimizerEngine.getMinOilLeft());
    }
}

