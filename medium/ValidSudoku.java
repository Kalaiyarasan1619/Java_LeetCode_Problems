package medium;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int index = num - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if (rows[i][index] || cols[j][index] || boxes[boxIndex][index]) {
                        return false;
                    }

                    rows[i][index] = true;
                    cols[j][index] = true;
                    boxes[boxIndex][index] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '6', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '2', '.', '5', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        boolean result = solution.isValidSudoku(board);
        System.out.println("Is the Sudoku valid? " + result);
    }

}
