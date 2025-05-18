package medium;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Handle overflow case
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long quotient = 0;

        while (absDividend >= absDivisor) {
            absDividend -= absDivisor;
            quotient++;
        }

        return isNegative ? (int) -quotient : (int) quotient;
    }

    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        int dividend = 10;
        int divisor = 3;
        int result = solution.divide(dividend, divisor);
        System.out.println("Result of division: " + result);
    }

}
