package hard;

public class ValidNumber {

    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty())
            return false;

        boolean hasNum = false, hasDot = false, hasE = false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                hasNum = true;
            } else if (c == '.') {
                if (hasDot || hasE)
                    return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasE || !hasNum)
                    return false;
                hasE = true;
                hasNum = false; // Reset for the exponent part
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } else {
                return false; // Invalid character
            }
        }
        return hasNum;
    }

    public static void main(String[] args) {
        ValidNumber solution = new ValidNumber();
        String[] testCases = {
                "0", " 0.1 ", "abc", "1 a", "2e10", "-90E3", "3.", ".1", "4e+", "+6e-1", "53.5e93",
                " --6 ", "-+3", "95a54e53"
        };

        for (String testCase : testCases) {
            System.out.println("Is \"" + testCase + "\" a valid number? " + solution.isNumber(testCase));
        }
    }

}
