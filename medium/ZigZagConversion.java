package medium;

public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if (numRows <= 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            if (curRow == 0) {
                goingDown = true;
            } else if (curRow == numRows - 1) {
                goingDown = false;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();

    }

    public static void main(String[] args) {
        ZigZagConversion solution = new ZigZagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = solution.convert(s, numRows);
        System.out.println("Converted string: " + result);
    }

}
