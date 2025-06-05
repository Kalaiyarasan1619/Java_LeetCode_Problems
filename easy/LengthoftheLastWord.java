package easy;

public class LengthoftheLastWord {

    public int lengthOfLastWord(String s) {
        // Trim the string to remove leading and trailing spaces
        s = s.trim();

        // Find the last space in the trimmed string
        int lastSpaceIndex = s.lastIndexOf(' ');

        // If there is no space, the entire string is the last word
        if (lastSpaceIndex == -1) {
            return s.length();
        }

        // Return the length of the last word
        return s.length() - lastSpaceIndex - 1;
    }

    public static void main(String[] args) {
        LengthoftheLastWord solution = new LengthoftheLastWord();
        String input = "Hello World";
        System.out.println("Length of the last word: " + solution.lengthOfLastWord(input)); // Output: 5
    }

}
