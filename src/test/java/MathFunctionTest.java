import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MathFunctionTest {

    private MathFunction mathFunction = new MathFunction();

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void testArcsin(double input, double expected){
        Assertions.assertEquals(expected, Math.ceil(mathFunction.arcsinInRow(input) * 1000) / 1000);
    }

}
