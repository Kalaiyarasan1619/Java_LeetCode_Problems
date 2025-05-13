package medium;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128]; // Assuming ASCII characters
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(charIndex[s.charAt(j)], i);
            maxLength = Math.max(maxLength, j - i + 1);
            charIndex[s.charAt(j)] = j + 1;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String input = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }

}
