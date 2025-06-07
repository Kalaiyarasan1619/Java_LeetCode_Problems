package medium;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        // Create a DP array to store the number of unique paths
        int[][] dp = new int[m][n];

        // Initialize the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // Only one way to reach any cell in the first column
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // Only one way to reach any cell in the first row
        }

        // Fill the rest of the DP array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of paths from top and left
            }
        }

        return dp[m - 1][n - 1]; // Return the bottom-right cell value
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int m = 3, n = 7;
        System.out.println("Unique paths from top-left to bottom-right: " + solution.uniquePaths(m, n)); // Output: 28
    }

}
