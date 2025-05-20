package hard;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int n = s.length();
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i >= dp[i - 1] + 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestValidParenthesis solution = new LongestValidParenthesis();
        String s = "(()))())(";
        int result = solution.longestValidParentheses(s);
        System.out.println("Longest valid parentheses length: " + result);
    }

}
