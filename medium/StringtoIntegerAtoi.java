package medium;

public class StringtoIntegerAtoi {

    public int myAtoi(String s) {

        int i = 0, sign = 1, result = 0;
        int n = s.length();

        // Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check for sign
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;

    }

    public static void main(String[] args) {
        StringtoIntegerAtoi solution = new StringtoIntegerAtoi();
        String s = "   -42";
        int result = solution.myAtoi(s);
        System.out.println("Converted integer: " + result);
    }

}
