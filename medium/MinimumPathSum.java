package medium;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // Create a DP array to store the minimum path sums
        int[][] dp = new int[m][n];

        // Initialize the first cell
        dp[0][0] = grid[0][0];

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the rest of the DP array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        };
        System.out.println("Minimum path sum: " + solution.minPathSum(grid)); // Output: 7
    }

}
