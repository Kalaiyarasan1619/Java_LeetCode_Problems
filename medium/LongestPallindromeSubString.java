package medium;

public class LongestPallindromeSubString {

    public String longestPalindrome(String s) {

        int n = s.length();
        if (n < 2) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // Single character is a palindrome
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && length > maxLength) {
                        start = i;
                        maxLength = length;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);

    }

    public static void main(String[] args) {
        LongestPallindromeSubString solution = new LongestPallindromeSubString();
        String input = "babad";
        String result = solution.longestPalindrome(input);
        System.out.println("Longest palindromic substring: " + result);
    }

}
