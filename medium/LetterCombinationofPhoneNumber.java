package medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationofPhoneNumber {

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return List.of();
        }

        String[] mapping = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), digits, mapping, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder combination, String digits, String[] mapping, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(result, combination, digits, mapping, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationofPhoneNumber solution = new LetterCombinationofPhoneNumber();
        String digits = "23";
        List<String> result = solution.letterCombinations(digits);
        System.out.println("Letter combinations: " + result);
    }

}
