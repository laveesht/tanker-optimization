import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EfficientDeliverySpecTest {
    @Test
    public void efficientSolution() {
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask("(2,3,5),5");
        EfficientDeliveryOptimizer efficientDeliveryOptimizer = new EfficientDeliveryOptimizer(tankerOptimizationTask);
        assertEquals(2, efficientDeliveryOptimizer.getEfficientSolutionsList().size());
        assertEquals("0,0,1", efficientDeliveryOptimizer.getEfficientSolutionsList().get(0));
        assertEquals("1,1,0", efficientDeliveryOptimizer.getEfficientSolutionsList().get(1));
    }

    @Test
    public void noEfficientSolution() {
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask("(2,7,11),5");
        EfficientDeliveryOptimizer efficientDeliveryOptimizer = new EfficientDeliveryOptimizer(tankerOptimizationTask);
        assertEquals(0, efficientDeliveryOptimizer.getEfficientSolutionsList().size());
        assertEquals(1, efficientDeliveryOptimizer.getMinOilLeft());
    }

    @Test
    public void oilLessThanTankerCapacity() {
        TankerOptimizationTask tankerOptimizationTask = new TankerOptimizationTask("(2,7,11),1");
        EfficientDeliveryOptimizer efficientDeliveryOptimizer = new EfficientDeliveryOptimizer(tankerOptimizationTask);
        assertEquals(0, efficientDeliveryOptimizer.getEfficientSolutionsList().size());
        assertEquals(1, efficientDeliveryOptimizer.getMinOilLeft());
    }
}

