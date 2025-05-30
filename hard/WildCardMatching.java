package hard;

public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true; // Empty string matches empty pattern

        // Handle patterns with leading '*'
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char cS = s.charAt(i - 1);
                char cP = p.charAt(j - 1);

                if (cP == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // Match zero or more characters
                } else if (cP == '?' || cS == cP) {
                    dp[i][j] = dp[i - 1][j - 1]; // Match single character
                }
            }
        }

        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        WildCardMatching solution = new WildCardMatching();
        String s = "adceb";
        String p = "*a*b";
        boolean result = solution.isMatch(s, p);
        System.out.println("Does the string match the pattern? " + result);
    }

}
