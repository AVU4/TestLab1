import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MathFunctionTest {

    private MathFunction mathFunction = new MathFunction();

    @ParameterizedTest
    @CsvFileSource(resources = "/rightData.csv", numLinesToSkip = 1)
    public void testArcsinRightData(double input, double expected){
        Assertions.assertEquals(expected, Math.round(mathFunction.arcsinInRow(input) * 1000.0) / 1000.0);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/badData.csv", numLinesToSkip = 1)
    public void testArcsinBadData(double input, double expected){

    }

}
