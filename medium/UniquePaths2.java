package medium;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Create a DP array to store the number of unique paths
        int[][] dp = new int[m][n];

        // Initialize the starting point
        dp[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j - 1] > 0) ? 1 : 0;
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] > 0) ? 1 : 0;
        }

        // Fill the rest of the DP array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // Obstacle found
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths2 solution = new UniquePaths2();
        int[][] obstacleGrid = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        System.out.println("Unique paths: " + solution.uniquePathsWithObstacles(obstacleGrid)); // Output: 2
    }

}
