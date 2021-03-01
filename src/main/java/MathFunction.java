import java.math.BigDecimal;
import java.util.HashMap;

public class MathFunction {

    public double arcsinInRow(double x) {
        double sum = 0;
        double compareSum = 0;
        boolean flag = true;
        int n = 0;
        while (flag || Math.abs(sum - compareSum) > 0.00015){
            flag = false;
            compareSum = sum;
            double mul1 = getFactorial(2 * n) / (Math.pow(2, 2 * n) * Math.pow(getFactorial(n), 2));
            double mul2 = Math.pow(x, 2 * n + 1) / (2 * n + 1);
            double result = mul1 * mul2;
            sum += result;
            n ++ ;
        }
        return sum;
    }

    private double getFactorial(int num) {
        double result = 1;
        for (int i = 1; i <= num; i ++){
            result *= i;
        }
        return result;
    }

}
