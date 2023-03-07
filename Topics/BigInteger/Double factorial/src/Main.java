import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = n; i > 0; i -= 2) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}