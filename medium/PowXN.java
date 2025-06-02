package medium;

public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double half = myPow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        double x = 2.0;
        int n = 10;
        double result = solution.myPow(x, n);
        System.out.println("Result of " + x + "^" + n + " is: " + result);
    }
}