package hard;

public class Nqueens2 {

    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n]; // Columns
        boolean[] diag1 = new boolean[2 * n - 1]; // Diagonal from top-left to bottom-right
        boolean[] diag2 = new boolean[2 * n - 1]; // Diagonal from top-right to bottom-left
        backtrack(0, n, cols, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!cols[col] && !diag1[row + col] && !diag2[row - col + n - 1]) {
                cols[col] = true;
                diag1[row + col] = true;
                diag2[row - col + n - 1] = true;
                backtrack(row + 1, n, cols, diag1, diag2);
                cols[col] = false;
                diag1[row + col] = false;
                diag2[row - col + n - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        Nqueens2 solution = new Nqueens2();
        int n = 4; // Example input
        System.out.println("Total solutions for " + n + " queens: " + solution.totalNQueens(n)); // Output: 2
    }

}
