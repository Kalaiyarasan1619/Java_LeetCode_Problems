package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthes {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generate(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generate(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParenthes solution = new GenerateParenthes();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println("Generated Parentheses: " + result);
    }

}
