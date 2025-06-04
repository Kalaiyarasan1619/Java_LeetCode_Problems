package hard;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result; // Return empty list for invalid input
        }
        boolean[] cols = new boolean[n]; // Columns
        boolean[] diag1 = new boolean[2 * n - 1]; // Diagonal from top-left to bottom-right
        boolean[] diag2 = new boolean[2 * n - 1]; // Diagonal from top-right to bottom-left
        backtrack(0, n, cols, diag1, diag2, new ArrayList<>(), result);
        return result;

    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2,
            List<String> current, List<List<String>> result) {
        if (row == n) {
            result.add(new ArrayList<>(current)); // Add a valid solution
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!cols[col] && !diag1[row + col] && !diag2[row - col + n - 1]) {
                cols[col] = true;
                diag1[row + col] = true;
                diag2[row - col + n - 1] = true;

                // Create a new row string with '.' and 'Q'
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(i == col ? 'Q' : '.');
                }
                current.add(sb.toString());

                backtrack(row + 1, n, cols, diag1, diag2, current, result);

                // Backtrack
                cols[col] = false;
                diag1[row + col] = false;
                diag2[row - col + n - 1] = false;
                current.remove(current.size() - 1); // Remove last added row
            }
        }
    }

    public static void main(String[] args) {
        Nqueens solution = new Nqueens();
        int n = 4; // Example input
        List<List<String>> result = solution.solveNQueens(n);
        System.out.println("Solutions for " + n + " queens: " + result); // Output: Solutions for 4 queens
    }

}
