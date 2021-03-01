import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class MathFunction {

//    public double arcsinInRow(double x) {
//        double sum = 0;
//        double compareSum = 0;
//        boolean flag = true;
//        int n = 0;
//        while (flag || Math.abs(sum - compareSum) > 0.000001){
//            flag = false;
//            compareSum = sum;
//            BigDecimal mul1 = getFactorial(2 * n).divide(BigDecimal.valueOf(Math.pow(2, 2 * n)).multiply(BigDecimal.valueOf(Math.pow(getFactorial(n).doubleValue(), 2))));
//            BigDecimal mul2 = BigDecimal.valueOf(Math.pow(x, 2 * n + 1)).divide(BigDecimal.valueOf(2 * n + 1), 10, RoundingMode.HALF_UP);
//            double result = mul1.multiply(mul2).doubleValue();
//            sum += result;
//            n ++ ;
//        }
//        return sum;
//    }

    private BigDecimal getFactorial(int num) {
        BigDecimal result = BigDecimal.valueOf(1);
        for (int i = 1; i <= num; i ++){
            result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }

    public double arcsinInRow(double x){
        if (Math.abs(x) > 1) return Double.NaN;
        double arg = x;
        if (x < 0) arg = -x;
        double y = arg;
        int n = 1;
        double sum = arg;
        double prev = 0;
        while (Math.abs(y - prev) > 0.000000000001) {
            prev = y;
            sum = sum * (2 + 1.0 / n ) * 0.5 * x * x;
            y = y + sum / (2 * n + 1) / (2 * n + 1);
            n = n + 1;
        }
        if(x < 0) y = -y;
        return y;
    }

}
