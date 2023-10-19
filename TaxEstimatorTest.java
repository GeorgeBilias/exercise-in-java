import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 /*-----------------------------
  * BILIAS GEORGIOS 3200278
  -----------------------------*/

public class TaxEstimatorTest {
    private TaxEstimator Estimator;
    private int estimatedTax;
    private TaxCalculator calculator;

    @BeforeEach
    void setUp() {
        Estimator = new TaxEstimator();
        calculator = (income) -> {
            return income;
        };
        Estimator.setCalculator(calculator);
    }
    
    @Test
    void testEstimateTaxForNegativeIncome(){
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {Estimator.estimateTax(-1000);});

    }
    
    @Test
    void testEstimateTaxForLessOrEqualTo1000(){

        estimatedTax = Estimator.estimateTax(500);
        Assertions.assertEquals(500, estimatedTax); 

    }
    
    @Test
    void testEstimateTaxForGreaterThan1000AndLessOrEqualTo3000(){

        estimatedTax = Estimator.estimateTax(1500);
        Assertions.assertEquals(1490, estimatedTax); 

    }
    
    @Test
    void testEstimateTaxForGreaterThan3000(){

        estimatedTax = Estimator.estimateTax(4000);
        Assertions.assertEquals(3600, estimatedTax); 

    }
}
